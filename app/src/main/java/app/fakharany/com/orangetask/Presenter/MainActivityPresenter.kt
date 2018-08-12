package app.fakharany.com.orangetask.Presenter

import android.content.Context
import android.support.v7.widget.PopupMenu
import android.util.Log
import android.view.MenuItem
import android.view.View
import app.fakharany.com.orangetask.Adapters.MyAdapter
import app.fakharany.com.orangetask.Model.MainActivityModel
import app.fakharany.com.orangetask.POJO.Result
import app.fakharany.com.orangetask.View.MainActivityView
import org.json.JSONArray


class MainActivityPresenter(var context: Context, var mView: MainActivityView, var model: MainActivityModel) :
        MainActivityModel.MainActivityModelListener, PopupMenu.OnMenuItemClickListener {


    var list = ArrayList<Result>()

    override fun getCategories(result: String) {
        Log.e("presenter", result)

        var root = JSONArray(result)
        for (i in 0 until root.length()) {

            var obj = root.getJSONObject(i)


            list.add(Result(obj.getString("id"),
                    obj.getString("name"),
                    obj.getString("icon"),
                    obj.getString("cat")))

        }

        prepareAdapter(list)
    }

    private fun prepareAdapter(list: ArrayList<Result>) {


        var adapter: MyAdapter.MyAdapter = MyAdapter.MyAdapter(context, list)

        mView.showList(adapter)
    }


    fun getMyList() {

        model.getListByVolley(this, context)

    }

    fun getMyList(flag: String) {
        if (flag.equals("all")) {

            getMyList()
            return
        }
        var adapterList = ArrayList<Result>()
        for (i in 0..list.size - 1) {
            if (flag == list.get(i).cat) {
                adapterList.add(list.get(i))
            }
        }
        prepareAdapter(adapterList)
    }

    fun showPopupMenu(v: View?) {
        val popup = PopupMenu(context, v!!)


        var strList = ArrayList<String>()


        for (u in 0..list.size - 1) {
            if (!strList.contains(list.get(u).cat))
                strList.add(list.get(u).cat)
        }

        strList.add("all")

        for (i in 0..strList.size - 1) {
            popup.menu.add(strList[i])
        }

        //registering popup with OnMenuItemClickListener
        popup.setOnMenuItemClickListener(this)

        mView.showOptionMenu(popup) //showing popup menu


    }

    override fun onMenuItemClick(p0: MenuItem?): Boolean {
        getMyList(p0!!.title.toString())
        return true
    }


}