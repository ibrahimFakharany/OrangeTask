package app.fakharany.com.orangetask

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PopupMenu
import android.view.View
import app.fakharany.com.orangetask.Adapters.MyAdapter
import app.fakharany.com.orangetask.Model.MainActivityModel
import app.fakharany.com.orangetask.Presenter.MainActivityPresenter
import app.fakharany.com.orangetask.View.MainActivityView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar.*

class MainActivity : AppCompatActivity(), MainActivityView, View.OnClickListener {
    override fun showOptionMenu(popupMenu: PopupMenu) {
        popupMenu.show()
    }

    override fun onClick(p0: View?) {
        presenter.showPopupMenu(p0)
    }

    override fun showList(adapter: MyAdapter.MyAdapter) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    var presenter = MainActivityPresenter(this, this, MainActivityModel())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.getMyList()

        img_dots.setOnClickListener(this)
    }


}
