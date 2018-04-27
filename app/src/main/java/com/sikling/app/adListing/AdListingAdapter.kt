package com.sikling.app.adListing

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.sikling.app.R

class AdListingAdapter : RecyclerView.Adapter<AdListingAdapter.AdsViewHolder>() {

    private val adsList = ArrayList<AdListingModel>()

    fun addAds(newAds: List<AdListingModel>) {
        adsList.addAll(newAds)
        notifyItemRangeInserted(itemCount, newAds.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_ad_listing, parent, false)
        return AdsViewHolder(v)
    }

    override fun getItemCount(): Int {
        return adsList.size
    }

    override fun onBindViewHolder(holder: AdsViewHolder, position: Int) {
        if (!adsList.isEmpty() && position < adsList.size) {
            val viewModel = adsList[position]

            //getShowItemInterface().showingItem(position)
            holder.title.text = viewModel.title
            holder.price.text = viewModel.price
            holder.date.text = viewModel.date
            Glide.with(holder.image.context).load(viewModel.image).into(holder.image)
            /*if (viewModel.image != "") {
                mImageLoader.loadImage(viewModel.image, holder.image)
            } else {
                showNoImage(viewHolder)
            }*/

            holder.favoritesButton?.post({
                if (position < adsList.size) {
                    //setFavorite(adExist(position), viewHolder)
                }
            })

            holder.favoritesButton?.setOnClickListener({ v ->
                object : Thread() {
                    override fun run() {
                        val adapterPosition = holder.adapterPosition
                        if (adapterPosition < adsList.size) {
                            /*val favoriteAd = listAdMapper.mapListItem(ads.get(adapterPosition))
                            if (favoritesInteractor.exist(favoriteAd)) {
                                if (favoritesInteractor.remove(favoriteAd.getListId())) {
                                    v.post({ setFavoriteOff(viewHolder) })
                                }
                            } else {
                                getItemClickListener().onItemAddFavoriteClick(ads.get(adapterPosition))
                                if (favoritesInteractor.add(favoriteAd)) {
                                    v.post({ setFavoriteOn(viewHolder) })
                                }
                            }*/
                        }
                    }
                }.start()
            })

            /*holder.card.setOnClickListener(
                    { v -> getItemClickListener().onItemClick(v, viewModel, viewHolder.getAdapterPosition(), searchHash) })
            if (!adsList.isEmpty() && position == 0) {
                getOnDistanceListener().onDistanceChange(viewModel.getDistance(), viewModel.getDistanceLabel())
            }*/
        }
    }

    inner class AdsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image: ImageView = view.findViewById(R.id.image)
        var title: TextView = view.findViewById(R.id.title)
        var price: TextView = view.findViewById(R.id.price)
        var date: TextView = view.findViewById(R.id.date)
        var favoritesButton: ImageButton? = null
    }
}