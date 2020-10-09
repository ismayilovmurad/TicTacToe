package com.martiandeveloper.tictactoe.view

import android.app.AlertDialog
import android.media.MediaPlayer
import android.os.Bundle
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
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.material.card.MaterialCardView
import com.martiandeveloper.tictactoe.R
import com.martiandeveloper.tictactoe.databinding.DialogPauseBinding
import com.martiandeveloper.tictactoe.databinding.FragmentGameBinding
import com.martiandeveloper.tictactoe.viewmodel.GameViewModel
import timber.log.Timber


class GameFragment : Fragment() {

    private lateinit var fragmentGameBinding: FragmentGameBinding

    private lateinit var gameViewModel: GameViewModel

    private lateinit var gameOverDialog: AlertDialog

    private lateinit var pauseDialog: AlertDialog

    private lateinit var interstitialAd: InterstitialAd

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

        interstitialAd = InterstitialAd(context)

        setAds()

        clickMediaPlayer = MediaPlayer.create(context, R.raw.click)

        setClick()
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

                if (interstitialAd.isLoaded) {
                    interstitialAd.show()
                }
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
                activate(fragmentGameBinding.fragmentGameFirstMCV, R.color.colorPrimaryDark)
            }
        })

        gameViewModel.isSecondMCVActive.observe(viewLifecycleOwner, {
            if (it) {
                activate(fragmentGameBinding.fragmentGameSecondMCV, R.color.colorPrimaryDark)
            }
        })

        gameViewModel.isThirdMCVActive.observe(viewLifecycleOwner, {
            if (it) {
                activate(fragmentGameBinding.fragmentGameThirdMCV, R.color.colorPrimaryDark)
            }
        })

        gameViewModel.isFourthMCVActive.observe(viewLifecycleOwner, {
            if (it) {
                activate(fragmentGameBinding.fragmentGameFourthMCV, R.color.colorPrimaryDark)
            }
        })

        gameViewModel.isFifthMCVActive.observe(viewLifecycleOwner, {
            if (it) {
                activate(fragmentGameBinding.fragmentGameFifthMCV, R.color.colorPrimaryDark)
            }
        })

        gameViewModel.isSixthMCVActive.observe(viewLifecycleOwner, {
            if (it) {
                activate(fragmentGameBinding.fragmentGameSixthMCV, R.color.colorPrimaryDark)
            }
        })

        gameViewModel.isSeventhMCVActive.observe(viewLifecycleOwner, {
            if (it) {
                activate(fragmentGameBinding.fragmentGameSeventhMCV, R.color.colorPrimaryDark)
            }
        })

        gameViewModel.isEighthMCVActive.observe(viewLifecycleOwner, {
            if (it) {
                activate(fragmentGameBinding.fragmentGameEighthMCV, R.color.colorPrimaryDark)
            }
        })

        gameViewModel.isNinthMCVActive.observe(viewLifecycleOwner, {
            if (it) {
                activate(fragmentGameBinding.fragmentGameNinthMCV, R.color.colorPrimaryDark)
            }
        })
    }

    private fun navigate(navDirections: NavDirections) {
        view?.let { Navigation.findNavController(it).navigate(navDirections) }
    }

    private fun activate(materialCardView: MaterialCardView, color: Int) {
        materialCardView.strokeColor =
            context?.let { it1 -> ContextCompat.getColor(it1, color) }!!
        materialCardView.strokeWidth = 4

        clickMediaPlayer.start()

        materialCardView.isEnabled = false
    }

    private fun setAds() {
        interstitialAd.adUnitId = getString(R.string.main_interstitial)

        val interstitialAdRequest = AdRequest.Builder().build()
        interstitialAd.loadAd(interstitialAdRequest)

        interstitialAd.adListener = object : AdListener() {
            override fun onAdClosed() {
                super.onAdClosed()
                interstitialAd.loadAd(interstitialAdRequest)
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

        if (!pauseDialog.isShowing && !gameOverDialog.isShowing) {
            showPauseDialog()
        }

    }

}
