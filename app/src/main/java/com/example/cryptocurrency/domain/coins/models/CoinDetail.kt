package com.example.cryptocurrency.domain.coins.models

import com.example.cryptocurrency.data.coins.dto.Tag
import com.example.cryptocurrency.data.coins.dto.TeamMember

data class CoinDetail(
    val id:String,
    val name:String,
    val description:String,
    val symbol:String,
    val rank:Int,
    val isActive:Boolean,
    val tags:List<Tag>,
    val team:List<TeamMember>
)