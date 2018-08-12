package app.fakharany.com.orangetask.View

import android.support.v7.widget.PopupMenu
import app.fakharany.com.orangetask.Adapters.MyAdapter

interface MainActivityView {

    fun showList(adapter: MyAdapter.MyAdapter)

    fun showOptionMenu(popupMenu: PopupMenu)


}