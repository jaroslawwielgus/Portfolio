package com.example.portfolio4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.portfolio4.databinding.FragmentProfileBinding

class ProfileFragment: Fragment() {
    val user: User?= MainActivity.user

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentProfileBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        binding.user = user

        //add user info to layout
        if (user != null) {
            val imgId: Int = resources.getIdentifier(user.photo, "drawable", "com.example.portfolio3")
            binding.profileImage.setImageResource(imgId)

            /* tez dziala:
            val uri: String = user.photo  // where myresource (without the extension) is the file
            val imageResource: Int = getResources().getIdentifier(uri, null, "com.example.portfolio3");
            val res: Drawable = getResources().getDrawable(imageResource);
            binding.profileImage.setImageDrawable(res);
              */

            for (i in user.jobs) {
                val jobView = TextView(context)
                val param1 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                jobView.layoutParams = param1
                jobView.text = i.title
                jobView.textSize=18F
                jobView.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

                val companyView = TextView(context)
                val param2 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                companyView.layoutParams = param2
                companyView.text = i.company
                companyView.textSize=18F
                companyView.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))

                val descriptionView = TextView(context)
                val param3 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                param3.setMargins(0, 0, 0, 16)
                descriptionView.layoutParams = param3
                descriptionView.text = i.description
                descriptionView.textSize=14F
                descriptionView.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))

                val lineView = View(context)
                val param4 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 3)
                param4.setMargins(0, 0, 0, 24)
                lineView.layoutParams = param4
                lineView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.light_light_gray))

                binding.apply {
                    jobsLayout.addView(jobView)
                    jobsLayout.addView(companyView)
                    jobsLayout.addView(descriptionView)
                    jobsLayout.addView(lineView)
                }
            }

            for (i in user.universities) {
                val academyView = TextView(context)
                val param1 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                academyView.layoutParams = param1
                academyView.text = i.academy
                academyView.textSize=18F
                academyView.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

                val fieldOfStudyView = TextView(context)
                val param2 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                fieldOfStudyView.layoutParams = param2
                fieldOfStudyView.text = i.field_of_study
                fieldOfStudyView.textSize=18F
                fieldOfStudyView.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))

                val descriptionView = TextView(context)
                val param3 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                param3.setMargins(0, 0, 0, 16)
                descriptionView.layoutParams = param3
                descriptionView.text = i.description
                descriptionView.textSize=14F
                descriptionView.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))

                val lineView = View(context)
                val param4 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 3)
                param4.setMargins(0, 0, 0, 24)
                lineView.layoutParams = param4
                lineView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.light_light_gray))

                binding.apply {
                    educationLayout.addView(academyView)
                    educationLayout.addView(fieldOfStudyView)
                    educationLayout.addView(descriptionView)
                    educationLayout.addView(lineView)
                }
            }

            for (i in user.languages) {
                val langView = TextView(context)
                val param1 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                langView.layoutParams = param1
                langView.text = i.lang
                langView.textSize=16F
                langView.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

                val levelView = TextView(context)
                val param2 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                param2.setMargins(0, 0, 0, 12)
                levelView.layoutParams = param2
                levelView.text = i.level
                levelView.textSize=16F

                val lineView = View(context)
                val param3 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 3)
                param3.setMargins(0, 0, 0, 24)
                lineView.layoutParams = param3
                lineView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.light_light_gray))


                binding.apply {
                    languagesLayout.addView(langView)
                    languagesLayout.addView(levelView)
                    languagesLayout.addView(lineView)
                }
            }

            for (i in user.activities) {
                val titleView = TextView(context)
                val param1 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                titleView.layoutParams = param1
                titleView.text = i.title
                titleView.textSize=18F
                titleView.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))

                val linkView = TextView(context)
                val param2 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                linkView.layoutParams = param2
                linkView.text = i.link
                linkView.textSize=14F
                linkView.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))

                val descriptionView = TextView(context)
                val param3 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                param3.setMargins(0, 0, 0, 16)
                descriptionView.layoutParams = param3
                descriptionView.text = i.description
                descriptionView.textSize=14F
                descriptionView.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))

                val lineView = View(context)
                val param4 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 3)
                param4.setMargins(0, 0, 0, 24)
                lineView.layoutParams = param4
                lineView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.light_light_gray))

                binding.apply {
                    activitiesLayout.addView(titleView)
                    activitiesLayout.addView(linkView)
                    activitiesLayout.addView(descriptionView)
                    activitiesLayout.addView(lineView)
                }
            }
        }

        return binding.root
    }
}