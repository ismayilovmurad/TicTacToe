package com.martiandeveloper.tictactoegame.view

import android.app.AlertDialog
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.google.android.material.card.MaterialCardView
import com.martiandeveloper.tictactoegame.R
import com.martiandeveloper.tictactoegame.databinding.DialogGameOverBinding
import com.martiandeveloper.tictactoegame.databinding.DialogPauseBinding
import com.martiandeveloper.tictactoegame.databinding.FragmentGameBinding
import com.martiandeveloper.tictactoegame.viewmodel.GameViewModel
import timber.log.Timber
import kotlin.random.Random

class GameFragment : Fragment() {

    private lateinit var fragmentGameBinding: FragmentGameBinding

    private lateinit var gameViewModel: GameViewModel

    private lateinit var gameOverDialog: AlertDialog

    private lateinit var pauseDialog: AlertDialog

    private lateinit var clickMediaPlayer: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentGameBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        return fragmentGameBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        gameViewModel = getViewModel()

        fragmentGameBinding.gameViewModel = gameViewModel
        fragmentGameBinding.lifecycleOwner = this

        gameOverDialog = AlertDialog.Builder(context).create()
        pauseDialog = AlertDialog.Builder(context).create()

        observe()

        clickMediaPlayer = MediaPlayer.create(context, R.raw.click)

        setClick()

        randomizeMyTurnOnStart()
    }

    private fun getViewModel(): GameViewModel {

        return ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return GameViewModel() as T
            }
        })[GameViewModel::class.java]

    }

    private fun showPauseDialog() {
        val binding = DialogPauseBinding.inflate(LayoutInflater.from(context))

        binding.gameViewModel = gameViewModel
        binding.lifecycleOwner = this

        pauseDialog.setView(binding.root)
        pauseDialog.setCanceledOnTouchOutside(false)
        pauseDialog.setCancelable(false)
        pauseDialog.show()
    }

    private fun observe() {

        gameViewModel.eventContinueMBTNClick.observe(viewLifecycleOwner, {
            if (it) {
                pauseDialog.dismiss()

                gameViewModel.onContinueMBTNClickComplete()
            }
        })

        gameViewModel.eventHomeMBTNClick.observe(viewLifecycleOwner, {
            if (it) {
                pauseDialog.dismiss()

                navigate(GameFragmentDirections.actionGameFragmentToHomeFragment())

                gameViewModel.onHomeMBTNClickComplete()
            }
        })

        gameViewModel.eventTryAgainMBTNClick.observe(viewLifecycleOwner, {
            if (it) {
                gameOverDialog.dismiss()

                navigate(GameFragmentDirections.actionGameFragmentSelf())

                gameViewModel.onTryAgainMBTNClickComplete()
            }
        })

        gameViewModel.eventHome2MBTNClick.observe(viewLifecycleOwner, {
            if (it) {
                gameOverDialog.dismiss()

                navigate(GameFragmentDirections.actionGameFragmentToHomeFragment())

                gameViewModel.onHome2MBTNClickComplete()
            }
        })

        gameViewModel.eventFirstMBTNClick.observe(viewLifecycleOwner, {
            if (it) {
                gameViewModel.setFirstMCVActive(true)
                gameViewModel.onFirstMBTNClickComplete()
            }
        })

        gameViewModel.eventSecondMBTNClick.observe(viewLifecycleOwner, {
            if (it) {
                gameViewModel.setSecondMCVActive(true)
                gameViewModel.onSecondMBTNClickComplete()
            }
        })

        gameViewModel.eventThirdMBTNClick.observe(viewLifecycleOwner, {
            if (it) {
                gameViewModel.setThirdMCVActive(true)
                gameViewModel.onThirdMBTNClickComplete()
            }
        })

        gameViewModel.eventFourthMBTNClick.observe(viewLifecycleOwner, {
            if (it) {
                gameViewModel.setFourthMCVActive(true)
                gameViewModel.onFourthMBTNClickComplete()
            }
        })

        gameViewModel.eventFifthMBTNClick.observe(viewLifecycleOwner, {
            if (it) {
                gameViewModel.setFifthMCVActive(true)
                gameViewModel.onFifthMBTNClickComplete()
            }
        })

        gameViewModel.eventSixthMBTNClick.observe(viewLifecycleOwner, {
            if (it) {
                gameViewModel.setSixthMCVActive(true)
                gameViewModel.onSixthMBTNClickComplete()
            }
        })

        gameViewModel.eventSeventhMBTNClick.observe(viewLifecycleOwner, {
            if (it) {
                gameViewModel.setSeventhMCVActive(true)
                gameViewModel.onSeventhMBTNClickComplete()
            }
        })

        gameViewModel.eventEighthMBTNClick.observe(viewLifecycleOwner, {
            if (it) {
                gameViewModel.setEighthMCVActive(true)
                gameViewModel.onEighthMBTNClickComplete()
            }
        })

        gameViewModel.eventNinthMBTNClick.observe(viewLifecycleOwner, {
            if (it) {
                gameViewModel.setNinthMCVActive(true)
                gameViewModel.onNinthMBTNClickComplete()
            }
        })

        gameViewModel.isFirstMCVActive.observe(viewLifecycleOwner, {
            if (it) {
                activate(fragmentGameBinding.fragmentGameFirstMCV, 1)
            }
        })

        gameViewModel.isSecondMCVActive.observe(viewLifecycleOwner, {
            if (it) {
                activate(fragmentGameBinding.fragmentGameSecondMCV, 2)
            }
        })

        gameViewModel.isThirdMCVActive.observe(viewLifecycleOwner, {
            if (it) {
                activate(fragmentGameBinding.fragmentGameThirdMCV, 3)
            }
        })

        gameViewModel.isFourthMCVActive.observe(viewLifecycleOwner, {
            if (it) {
                activate(fragmentGameBinding.fragmentGameFourthMCV, 4)
            }
        })

        gameViewModel.isFifthMCVActive.observe(viewLifecycleOwner, {
            if (it) {
                activate(fragmentGameBinding.fragmentGameFifthMCV, 5)
            }
        })

        gameViewModel.isSixthMCVActive.observe(viewLifecycleOwner, {
            if (it) {
                activate(fragmentGameBinding.fragmentGameSixthMCV, 6)
            }
        })

        gameViewModel.isSeventhMCVActive.observe(viewLifecycleOwner, {
            if (it) {
                activate(fragmentGameBinding.fragmentGameSeventhMCV, 7)
            }
        })

        gameViewModel.isEighthMCVActive.observe(viewLifecycleOwner, {
            if (it) {
                activate(fragmentGameBinding.fragmentGameEighthMCV, 8)
            }
        })

        gameViewModel.isNinthMCVActive.observe(viewLifecycleOwner, {
            if (it) {
                activate(fragmentGameBinding.fragmentGameNinthMCV, 9)
            }
        })

        gameViewModel.myTurn.observe(viewLifecycleOwner, {
            if (it) {
                gameViewModel.setTurnText(getString(R.string.your_turn))
                gameViewModel.setColor(R.color.colorPrimaryDark)
                fragmentGameBinding.fragmentGameTurnMTV.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        gameViewModel.color.value!!
                    )
                )
            } else {
                gameViewModel.setTurnText(getString(R.string.androids_turn))
                gameViewModel.setColor(R.color.colorThree)
                fragmentGameBinding.fragmentGameTurnMTV.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        gameViewModel.color.value!!
                    )
                )
                generateAndroidsMove()
            }
        })
    }

    private fun navigate(navDirections: NavDirections) {
        view?.let { Navigation.findNavController(it).navigate(navDirections) }
    }

    private fun activate(materialCardView: MaterialCardView, move: Int) {
        materialCardView.strokeColor =
            context?.let { it1 -> ContextCompat.getColor(it1, gameViewModel.color.value!!) }!!
        materialCardView.strokeWidth = 4

        clickMediaPlayer.start()

        materialCardView.isClickable = false

        if (gameViewModel.myTurn.value == true) {
            gameViewModel.addYourMove(move)

            gameViewModel.setGameOverText(getString(R.string.you_won))

            checkWinner(gameViewModel.yourMoves.value!!, false)
        } else {
            activateMoves(true)
            gameViewModel.addAndroidsMove(move)

            gameViewModel.setGameOverText(getString(R.string.android_won))

            checkWinner(gameViewModel.androidsMoves.value!!, true)
        }
    }

    private fun checkWinner(list: ArrayList<Int>, myTurn: Boolean) {
        if (list.contains(1) && list.contains(2) && list.contains(3)) {
            showGameOverDialog()
        } else if (list.contains(4) && list.contains(5) && list.contains(6)) {
            showGameOverDialog()
        } else if (list.contains(7) && list.contains(8) && list.contains(9)) {
            showGameOverDialog()
        } else if (list.contains(1) && list.contains(4) && list.contains(7)) {
            showGameOverDialog()
        } else if (list.contains(2) && list.contains(5) && list.contains(8)) {
            showGameOverDialog()
        } else if (list.contains(3) && list.contains(6) && list.contains(9)) {
            showGameOverDialog()
        } else if (list.contains(1) && list.contains(5) && list.contains(9)) {
            showGameOverDialog()
        } else if (list.contains(3) && list.contains(5) && list.contains(7)) {
            showGameOverDialog()
        } else {

            if (gameViewModel.isFirstMCVActive.value == true &&
                gameViewModel.isSecondMCVActive.value == true &&
                gameViewModel.isThirdMCVActive.value == true &&
                gameViewModel.isFourthMCVActive.value == true &&
                gameViewModel.isFifthMCVActive.value == true &&
                gameViewModel.isSixthMCVActive.value == true &&
                gameViewModel.isSeventhMCVActive.value == true &&
                gameViewModel.isEighthMCVActive.value == true &&
                gameViewModel.isNinthMCVActive.value == true
            ) {

                gameViewModel.setGameOverText(getString(R.string.equal))
                showGameOverDialog()
            } else {
                gameViewModel.setMyTurn(myTurn)
            }
        }
    }

    private fun setClick() {

        try {
            clickMediaPlayer.prepare()
        } catch (e: Exception) {
            Timber.e(e.localizedMessage)
        }

    }

    override fun onResume() {
        super.onResume()

        if (gameViewModel.isFirst.value != true && !pauseDialog.isShowing && !gameOverDialog.isShowing) {
            showPauseDialog()
        }

        gameViewModel.setFirst(false)

    }

    private fun randomizeMyTurnOnStart() {
        gameViewModel.setMyTurn(Random.nextBoolean())
    }

    private fun generateAndroidsMove() {
        activateMoves(false)

        generate()
    }

    private fun generate() {
        Handler(Looper.getMainLooper()).postDelayed({

            when (Random.nextInt(1, 10)) {
                1 -> {
                    if (gameViewModel.isFirstMCVActive.value != true) {
                        gameViewModel.setFirstMCVActive(true)
                    } else {
                        generate()
                    }
                }

                2 -> {
                    if (gameViewModel.isSecondMCVActive.value != true) {
                        gameViewModel.setSecondMCVActive(true)
                    } else {
                        generate()
                    }
                }

                3 -> {
                    if (gameViewModel.isThirdMCVActive.value != true) {
                        gameViewModel.setThirdMCVActive(true)
                    } else {
                        generate()
                    }
                }

                4 -> {
                    if (gameViewModel.isFourthMCVActive.value != true) {
                        gameViewModel.setFourthMCVActive(true)
                    } else {
                        generate()
                    }
                }

                5 -> {
                    if (gameViewModel.isFifthMCVActive.value != true) {
                        gameViewModel.setFifthMCVActive(true)
                    } else {
                        generate()
                    }
                }

                6 -> {
                    if (gameViewModel.isSixthMCVActive.value != true) {
                        gameViewModel.setSixthMCVActive(true)
                    } else {
                        generate()
                    }
                }

                7 -> {
                    if (gameViewModel.isSeventhMCVActive.value != true) {
                        gameViewModel.setSeventhMCVActive(true)
                    } else {
                        generate()
                    }
                }

                8 -> {
                    if (gameViewModel.isEighthMCVActive.value != true) {
                        gameViewModel.setEighthMCVActive(true)
                    } else {
                        generate()
                    }
                }

                9 -> {
                    if (gameViewModel.isNinthMCVActive.value != true) {
                        gameViewModel.setNinthMCVActive(true)
                    } else {
                        generate()
                    }
                }

            }

        }, Random.nextInt(1000, 2000).toLong())
    }

    private fun activateMoves(active: Boolean) {
        if (gameViewModel.isFirstMCVActive.value != true) {
            fragmentGameBinding.fragmentGameFirstMCV.isClickable = active
        }

        if (gameViewModel.isSecondMCVActive.value != true) {
            fragmentGameBinding.fragmentGameSecondMCV.isClickable = active
        }

        if (gameViewModel.isThirdMCVActive.value != true) {
            fragmentGameBinding.fragmentGameThirdMCV.isClickable = active
        }

        if (gameViewModel.isFourthMCVActive.value != true) {
            fragmentGameBinding.fragmentGameFourthMCV.isClickable = active
        }

        if (gameViewModel.isFifthMCVActive.value != true) {
            fragmentGameBinding.fragmentGameFifthMCV.isClickable = active
        }

        if (gameViewModel.isSixthMCVActive.value != true) {
            fragmentGameBinding.fragmentGameSixthMCV.isClickable = active
        }

        if (gameViewModel.isSeventhMCVActive.value != true) {
            fragmentGameBinding.fragmentGameSeventhMCV.isClickable = active
        }

        if (gameViewModel.isEighthMCVActive.value != true) {
            fragmentGameBinding.fragmentGameEighthMCV.isClickable = active
        }

        if (gameViewModel.isNinthMCVActive.value != true) {
            fragmentGameBinding.fragmentGameNinthMCV.isClickable = active
        }
    }

    private fun showGameOverDialog() {
        val binding = DialogGameOverBinding.inflate(LayoutInflater.from(context))

        binding.gameViewModel = gameViewModel
        binding.lifecycleOwner = this

        gameOverDialog.setView(binding.root)
        gameOverDialog.setCanceledOnTouchOutside(false)
        gameOverDialog.setCancelable(false)
        gameOverDialog.show()
    }

}
