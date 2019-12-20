package com.yyz.livedatatest

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.yyz.livedatatest.viewmodel.RedPointViewModel

/**
 * @author yyz (杨云召)
 * @date   2019/12/19
 * time   17:22
 * description
 */
class TabLayoutTestActivity : AppCompatActivity() {

    private lateinit var mRedPointVewModel: RedPointViewModel
    private lateinit var mTabLayout: TabLayout
    private lateinit var mViewPager: ViewPager
    private val titles = arrayOf("推荐应用", "必装应用", "应用管理")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablayout_test)
        mRedPointVewModel = ViewModelProviders.of(this).get(RedPointViewModel::class.java)

        mViewPager = findViewById<ViewPager>(R.id.viewPager).apply {
            offscreenPageLimit = 3
            adapter = PageAdapter(supportFragmentManager)
        }

        mTabLayout = findViewById<TabLayout>(R.id.tab_layout).apply {
            setupWithViewPager(mViewPager)
            tabMode = TabLayout.MODE_FIXED

            //setupWithViewPager tabLayout与viewpager联动后,标题会由getPageTitle控制，移除所有tab，使用自定义view的tab
            removeAllTabs()
            for (i in titles.indices) {
                addTab(newTab().apply {
                    customView =
                        View.inflate(this@TabLayoutTestActivity, R.layout.layout_tab, null).apply {
                            findViewById<AppCompatTextView>(R.id.tv_title).text = titles[i]
                            findViewById<AppCompatTextView>(R.id.tv_red_point).visibility = View.INVISIBLE
                        }
                })
            }
        }
        mRedPointVewModel.redPoint.observe(this, Observer {
            Log.i("yyz", "监听红点变化 $it")
            mTabLayout.getTabAt(2)?.customView?.findViewById<AppCompatTextView>(R.id.tv_red_point)
                ?.visibility =
                if (it) View.VISIBLE else View.INVISIBLE
        })
    }

    inner class PageAdapter(fm: FragmentManager) :
        FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getItem(position: Int): Fragment =
            ContentFragment.newInstance(titles[position])

        override fun getCount(): Int = titles.size
    }
}