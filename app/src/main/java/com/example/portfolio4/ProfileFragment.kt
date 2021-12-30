package com.example.portfolio4

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.marginTop
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.portfolio4.databinding.FragmentProfileBinding
import org.w3c.dom.Text

class ProfileFragment: Fragment() {
    val user: User? = LogInFragment.foundUser

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentProfileBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        binding.user = user

        //add user info to layout
        if (user != null) {
            for (i in user.jobs) {
                /*
                val relativeLayout = RelativeLayout(context)
                val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                relativeLayout.layoutParams = params
                relativeLayout.setPadding(16, 8, 8, 0)
                */
                val jobView = TextView(context)
                val param1 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                jobView.layoutParams = param1
                jobView.text = i.title

                val companyView = TextView(context)
                val param2 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                companyView.layoutParams = param2
                companyView.text = i.company

                val descriptionView = TextView(context)
                val param3 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                descriptionView.layoutParams = param3
                descriptionView.text = i.description
                descriptionView.setPadding(0, 0 , 0, 16)

                binding.apply {
                    jobsLayout.addView(jobView)
                    jobsLayout.addView(companyView)
                    jobsLayout.addView(descriptionView)
                }
            }

            for (i in user.universities) {
                val academyView = TextView(context)
                val param1 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                academyView.layoutParams = param1
                academyView.text = i.academy

                val fieldOfStudyView = TextView(context)
                val param2 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                fieldOfStudyView.layoutParams = param2
                fieldOfStudyView.text = i.field_of_study

                val descriptionView = TextView(context)
                val param3 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                descriptionView.layoutParams = param3
                descriptionView.text = i.description
                descriptionView.setPadding(0, 0 , 0, 16)

                binding.apply {
                    educationLayout.addView(academyView)
                    educationLayout.addView(fieldOfStudyView)
                    educationLayout.addView(descriptionView)
                }
            }

            for (i in user.languages) {
                val langView = TextView(context)
                val param1 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                langView.layoutParams = param1
                langView.text = i.lang

                val levelView = TextView(context)
                val param2 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                levelView.layoutParams = param2
                levelView.text = i.level
                levelView.setPadding(0, 0 , 0, 16)

                binding.apply {
                    languagesLayout.addView(langView)
                    languagesLayout.addView(levelView)
                }
            }

            for (i in user.activities) {
                val titleView = TextView(context)
                val param1 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                titleView.layoutParams = param1
                titleView.text = i.title

                val linkView = TextView(context)
                val param2 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                linkView.layoutParams = param2
                linkView.text = i.link

                val descriptionView = TextView(context)
                val param3 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                descriptionView.layoutParams = param3
                descriptionView.text = i.description
                descriptionView.setPadding(0, 0 , 0, 16)

                binding.apply {
                    activitiesLayout.addView(titleView)
                    activitiesLayout.addView(linkView)
                    activitiesLayout.addView(descriptionView)
                }
            }
        }

        return binding.root
    }
}