package app.fakharany.com.orangetask.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import app.fakharany.com.orangetask.POJO.Result
import app.fakharany.com.orangetask.R

class MyAdapter {

    class MyAdapter(var context: Context, var list: ArrayList<Result>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        var inflater: LayoutInflater? = null

        init {
            inflater = LayoutInflater.from(context)
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
            return MyViewHolder(inflater!!.inflate(R.layout.item_recycler_view, parent, false))
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
            holder!!.id!!.text = list.get(position).id
            holder!!.name!!.text = list.get(position).name
//            holder!!.icon!!.text = list.get(position).icon
            holder!!.cat!!.text = list.get(position).cat
        }

        class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
            var id: TextView? = null
            var name: TextView? = null

            var cat: TextView? = null

            init {
                id = itemView!!.findViewById(R.id._id)
                name = itemView!!.findViewById(R.id._name)

                cat = itemView!!.findViewById(R.id._cat)
            }
        }

    }
}