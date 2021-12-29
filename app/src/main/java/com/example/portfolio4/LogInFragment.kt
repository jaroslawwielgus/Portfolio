package com.example.portfolio4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.portfolio4.databinding.FragmentLogInBinding


class LogInFragment: Fragment() {

    private lateinit var user1: User
    private lateinit var user2: User
    private lateinit var user3: User
    private lateinit var user4: User

    private lateinit var users: List<User>

    companion object {
        var foundUser: User? = null
    }


    private fun addUsers() {
        //users' jobs
        val job1_u1 = Job(1, "Web developer", "ABC", "Implementing askfhkbdwj  afkbsw,jfjw wjhfkubew uiwfwe fuibwf weuifwf wufbwek wkjgfbkwe whjkfbkwe akjfgkydw w,jhfbkuej", "PL", "Wrocław", "Dolnośląskie")
        val job2_u1 = Job(2, "Web developer", "XYZ", "ah,fbkdjs, slkfbwukfwrek wuifkgbwukgkrew fwrebure nmweugbrekubre wjh,efyuwe hkfbwyekfgkb", "PL", "Wrocław", "Dolnośląskie")
        val job3_u1 = Job(3, "Web designer", "XYZ", "Asfkjbsbdjmvjhbe kjdfbk,skjv wsdkfjwdk,v wkjefhlkrebjvlkre, wksjfn,rekjjbv, sdh,bfvkbhfd jhwsbfkyujrevhjehkj bjhsf", "PL", "Wrocław", "Dolnośląskie")
        var jobs_u1 = listOf<Job>(job1_u1, job2_u1, job3_u1)

        val job1_u2 = Job(4, "Java developer", "ADA", "Adsjhbafkgsdb iwusfhkwk ilufhilwhuifwnileviu jeksfkguw wkbufuweu, wkljdbkkvygurew cwekfukwrebcv wkbreyufkbre nmw jhkbkuwrekbvbrejbhve.", "PL", "Wrocław", "Dolnośląskie")
        val job2_u2 = job1_u1
        var jobs_u2 = listOf<Job>(job1_u2, job2_u2)

        val job1_u3 = Job(5, ".NET developer", "KASD", "Lakjbfkudsuf wekfuiwe ewkjfkuiwe wuifoilew fiuwehfliuew uiwfgiew biwiufuew uewfuliwe fewifhulreio;gornh jkjbwfbe nmekbjlv", "PL", "Kraków", "Małopolskie")
        val job2_u3 = Job(6, "Junior Software Engineer", "AlexCo", "Sadaskjfhjkdc jhkfbwd,s cewkjbfkucew wejkbkewb wejfbiulewkj kjhwbvuilkwrej nmvwelkjbvkurej vrelkjvbrekvbkre bkjlwvli", "EN", "London", "Greater London")
        val job3_u3 = Job(7, "Network Engineer", "Itewd", "ahjsdbhjsa casjhdkeusaj qwjhafkuew jhqwgfku,we ,jhwegafkuybjewn jhbkeagfk wejhafgkbj,ews jhbewafykwejh jhewfvkjwejh", "EN", "London", "Greater London")
        var jobs_u3 = listOf<Job>(job1_u3, job2_u3, job3_u3)

        val job1_u4 = job1_u1
        val job2_u4 = Job(8, ".NET developer", "Erno", "Apoewkncdwbsc wjhefjwe wekjfw bhjkwfk bhwef nmjkbwef wjh,wbjhfwn jh wejf hfjhdswmw mjwefhjwe mwefjmwre wjhefhwe", "PL", "Brzeg", "Opolskie")
        val jobs_u4 = listOf<Job>(job1_u4, job2_u4)

        //users' universities
        val university1_u1 = University(1, "PWr", "Informatyka", "adksakhjfbhjds shjbdfmhdjs hjbsdfbsd kjdfjds nmdsfhds nw,kjdf,jre jweureb")
        val university2_u1 = University(2, "PW", "Informatyka", "akdjabhf sjf,dbs jasdf,djs h,jsdgvkds, dsgvdsk kjdsfb,ds mjvjhcjfhgjcmvn hg")
        var universities_u1 = listOf<University>(university1_u1, university2_u1)

        val university1_u2 = university1_u1
        var universities_u2 = listOf<University>(university1_u2)

        val university1_u3 = University(3, "AGH", "Informatyka", "absvkcjhdsvjds jh,dsvkbjdhbv sdjvhulds sd,kfhuds js dsluifulds dsv sjhfbjdsh")
        val university2_u3 = University(4, "AMuzKr", "Instrumentalistyka", "Asfknjdskfv nskjsfdbs iusdfufdsvfhuifusi suihvhuilrehhuifl jhbkjhvkjhvkyjhhj")
        var universities_u3 = listOf<University>(university1_u3, university2_u3)

        val university1_u4 = University(5, "UWr", "Informatyka", "Ajhbfvjgcs dmjcdsjvjhe kcwjdhdsf, sd,hbvjgds shdvj, as,hfbvjdshbj.")
        var universities_u4 = listOf<University>(university1_u4)

        //users' languages
        val language1_u1 = Language(1, "POLSKI", "Język ojczysty")
        val language2_u1 = Language(2, "ANGIELSKI", "Pełna biegłość zawodowa")
        val language3_u1 = Language(3, "NIEMIECKI", "Biegłość na poziomie zaawansowanym")
        var languages_u1 = listOf<Language>(language1_u1, language2_u1, language3_u1)

        val language1_u2 = language1_u1
        val language2_u2 = language2_u1
        val language3_u2 = Language(4, "NIEMIECKI", "Pełna biegłość zawodowa")
        var languages_u2 = listOf<Language>(language1_u2, language2_u2, language3_u2)

        val language1_u3 = language1_u1
        val language2_u3 = Language(5, "ANGIELSKI", "Biegłość na poziomie zaawansowanym")
        val language3_u3 = Language(6, "Francuski", "Pełna biegłość zawodowa")
        var languages_u3 = listOf<Language>(language1_u3, language2_u3, language3_u3)

        val language1_u4 = language1_u1
        val language2_u4 = language2_u1
        var languages_u4 = listOf<Language>(language1_u4, language2_u4)

        //users' activities

        val activity1_u1 = Activity(1, "Moja stronka 1", "www.github.com/ap/1", "zxajfdscuicbdjsch,uv dsbu,jsdvdfs sdfvdf dsfgdfsvdsvdsvdsveds asdfmjmvcdsjyhcdshjhjcvdsb,jds")
        val activity2_u1 = Activity(2, "Moja stronka 2", "www.github.com/ap/2", "sajdfuhwsd,j ajsdfuiwesa eqwukjsahfliuews nfliwjshfliukecwds nmfewuksjfuiwekds fjvewliusjhlwe nasjh,zfuckewds redilhpbotrfdewasyu")
        val activity3_u1 = Activity(3, "Fajne szablony", "www.xyz.com/patterns/z", "sahdygukaz na,ukfskuds, ,asjfiud,swb nme,ajdfiu,jesd ,jasfb,jkds ,jksdjgb kjhauihfslabk pwoqwpwqurewfbjw e,jhrbufiwes")
        var activities_u1 = listOf<Activity>(activity1_u1, activity2_u1, activity3_u1)

        val activity1_u2 = Activity(4, "Moja gra 1", "www.github.com/xp/1", "asfkdhksuaicbj wes,fjuksd,j vliuwekjhdsfaliukjre smniuwekjahdifusgreuksjgr")
        val activity2_u2 = Activity(5, "Moja gra 2", "www.github.com/xp/2", "asijodbwsj,c ksjfhliewkhdsfliuwe wekjfiuwe wejkfhiuwe ialdlhiwea nluhiewf vewukflews vleiwshfliekw svliews")
        val activity3_u2 = Activity(6, "Stworzona stronka", "www.github.com/xp/3", "asdnjkfahckdjsab ajs akfle weilr9;ew qpoeqw asbhc uqdfew qkfh uqwhludiwe iuqwdhfuwel akjshf")
        var activities_u2 = listOf<Activity>(activity1_u2, activity2_u2, activity3_u2)

        val activity1_u3 = Activity(7, "Projekt sieci 1", "www.qweryy.com/ad/1", "asdkbfadkhj mfbkdsjafkbjewbsafk,wejba,s w,afuivwesb mjhwafewsb mejhw kjb,fkbewfuewkfu,ewuisuilfew uewjhflivwekhdfsew iufekjwhslfiukjewbds fvewli")
        val activity2_u3 = Activity(8, "Projekt sieci 2", "www.qweryy.com/ad/2", "asjnfwduils,afliew aliewkjhsalifukew fliuewkjhlfiuew dsfliuwekjhfuilekwjhlisufkhewilsf ewilkjhfliuwehfliuewa fewkjhfliuwebuilfew")
        val activity3_u3 = Activity(9, "Gra w C#", "www.github.com/av", "adkjba sdkjbas djqwkd bliuwe awqukj hfaliuwqb qwhkjdh fliuweahdb asdafv wefwlsc wiuwekfluikewhf cewkjfhluiwehfewhui ewjhfliuwekhb ashfbcab akfbea")
        val activity4_u3 = Activity(10, "Learning piano", "www.yt.com/li", "asdjnasuk,fbdcs ,kjahsuif,kcewbsa ciau lks jhfliucw ekjsahl ukwsa ajshkd ")
        var activities_u3 = listOf<Activity>(activity1_u3, activity2_u3, activity3_u3, activity4_u3)

        val activity1_u4 = Activity(11, "Projekt gry", "www.github.com/aoo/1", "asdsafkj askfhulds ask,fhlkda kjasfhlad jasfdaisf askfkda akjsfb,da afkjdeds qwifwe")
        val activity2_u4 = Activity(12, "Moja stronka", "www.github.com/aoo/2", "Asdnkjfdskc akjsfhulid kjasfhdsal sakfhdahflda aksjdfdsakj ajdfjbdsjbfbda")
        var activities_u4 = listOf<Activity>(activity1_u4, activity2_u4)

        //creating users
        user1 = User(1, "Jan", "Kowalski", "e@e.com", "pass", "user1", "ajsdb ajdbf,shj abd,fs ajdb,jhsdb,djhsabd,abfs  as,dbf,sdjha d,hbs e,jsdbewkj,sb cajkdfbk,jfbewdusifkjbews ceuwkjbfcuewkdjsb",
            jobs_u1, universities_u1, languages_u1, activities_u1
        )
        user2 = User(2, "Jan", "Kowalski", "e@e2.com", "pass2", "user2", "asdcfs asjfd,s kjasdfbds,j akjdsf,dsjna a,jdb,asjbfa kjad,akjfhlewkfhjew kwej,jfuewkjfb wekjfhnlweflkwe fuewkhliuwekhlfbuwe qhuwjfluiwesukf akfhweln wuefhnwel",
            jobs_u2, universities_u2, languages_u2, activities_u2
        )
        user3 = User(3, "Jakub", "Kowalski", "e@e3.com", "pass3", "user3", "Asfds sdgvbfd hb,dsjmcv ajhsfbksdyjmh vs,jfbkusd,jbv, s,ui,jkes,dbfkujwbsdkjv, dsnbuewudskfhjvewkdjsfhjbvkes kwejhfiukjs skfjhksdjv skjfhskjv  iusfvsukjhfuis skjfhkshu uhskfhjskjreioutwio .,afnkbkwuys wesv",
            jobs_u3, universities_u3, languages_u3, activities_u3
        )
        user4 = User(4, "Michał", "Nowak", "e@e4.com", "pass4", "user4", "AKJbjhx,cba, kjndsbksu, kudjs,bvu,js uwjfdshkusud jsbusdkj alidoiqwefhgryek iulwefkjbwekj kwljfbiulweuhf,ew wjkfluiwefu iuhwlfhbw uwelhfulwufhwe wiuhleflweluifhluwe weilujflwuhf uhwfhweilufhw iuhwflhew ulwefhlwefhu wlufhluewu",
            jobs_u4, universities_u4, languages_u4, activities_u4
        )
        //adding users to list
        users = listOf(user1, user2, user3, user4)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentLogInBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_log_in, container, false)

        addUsers()

        //if (binding.emailTextField.isActivated) {
            //binding.emailTextField.setHelperTextColor(Color.valueOf())
        //}
        /*
        binding.apply {
            if (emailEditText.text == null) {
                emailEditText.setError("Please enter email")
            }
        }
        */
        /*
        binding.emailEditText.setOnClickListener {
            binding.apply {
                if (emailEditText.text == null) {
                    emailEditText.setError("Please enter email")
                }
            }
        }

         */

        /* Initial validation

        binding.emailEditText.doOnTextChanged { text, start, before, count ->
            if (!text!!.contains('@')) {
                binding.emailTextField.error = "Wykorzystaj '@'"
            } else {
                binding.emailTextField.error = null;
            }
        }

         */

        binding.confirmButton.setOnClickListener { v:View ->
            var checkEmailWithPassword = true
            /*
            if ((binding.emailEditText.text)?.equals("") == true) {
                binding.apply {
                    emailTextField.error = "Puste"
                    checkEmailWithPassword = false;
                }
            }
            if ((binding.passwordEditText.text)?.equals("") == true) {
                binding.apply {
                    emailTextField.error = "Pusty"
                    checkEmailWithPassword = false;
                }
            }


            binding.emailEditText.doOnTextChanged { text, start, before, count ->
                if (!text!!.contains('@')) {
                    binding.emailTextField.error = "Wykorzystaj '@'"
                } else {
                    binding.emailTextField.error = null;
                }
            }
            */

            var isFound: Boolean = false

            if (checkEmailWithPassword) {
                for(i in users) {
                    if ((binding.emailTextField.editText?.text.toString()).equals(i.email) == true
                        && (binding.passwordTextField.editText?.text.toString()).equals(i.password) == true) {
                        isFound = true
                        foundUser = i
                        //go to next screen
                        v.findNavController().navigate(LogInFragmentDirections.actionLogInFragmentToSearchingFragment())
                        break
                    }
                }
                if (!isFound) {
                    binding.apply {
                        emailTextField.error = "Niepoprawny"
                        passwordTextField.error = "Niepoprawne"
                    }
                }
            }

            /*
            if (checkEmailWithPassword) {
                if ((binding.emailTextField.editText?.text.toString()).equals(email) == true
                    && (binding.passwordTextField.editText?.text.toString()).equals(password) == true) {
                    //go to next screen
                    v.findNavController().navigate(LogInFragmentDirections.actionLogInFragmentToSearchingFragment())

                } else {
                    binding.apply {
                        emailTextField.error = "Niepoprawny"
                        passwordTextField.error = "Niepoprawne"
                    }
                }
            }
             */
        }


        return binding.root
    }

}