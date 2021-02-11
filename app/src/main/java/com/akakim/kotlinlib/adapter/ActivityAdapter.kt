package com.akakim.kotlinlib.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.akakim.kotlinlib.R
import com.akakim.kotlinlib.adapter.ActivityAdapter.*

/**
 * @author KIM
 * @version 0.0.1
 * @since 0.0.1
 * @date 2021-01-30
 */
class ActivityAdapter : RecyclerView.Adapter<ActivityHolder> {

    var activityList : MutableList<ActivityItem>
    var itemClickListener : OnClickListener

    constructor( activityItemClickListener: OnClickListener,activityList: MutableList<ActivityItem> ) : super(){
        this.activityList = activityList
        this.itemClickListener = activityItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityHolder {
        val view : View =  LayoutInflater.from(parent.context).inflate(R.layout.item_activity,parent,false)

        return ActivityHolder(view);
    }

    override fun getItemCount(): Int {
        return activityList.size
    }

    override fun onBindViewHolder(holder: ActivityHolder, position: Int) {
        holder.bind( activityList.get(position) ,itemClickListener)
    }

    inner class ActivityHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val tvSummery  = itemView.findViewById<AppCompatTextView>(R.id.tvSummery)

        fun bind( activityItem: ActivityItem,itemClickListener : OnClickListener){
            Log.d("RvMain","onBind?");
            tvSummery.text = activityItem.description

            itemView.setOnClickListener {
                Log.d("RvMain","onClick?");
                itemClickListener.onClickITem( activityItem )
            }
        }

    }

    public interface OnActivityClickListener {
        fun onActivityClick( item : ActivityItem )

    }
}