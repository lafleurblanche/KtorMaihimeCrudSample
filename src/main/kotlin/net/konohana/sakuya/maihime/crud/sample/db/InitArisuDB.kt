package net.konohana.sakuya.maihime.crud.sample.db

import org.jetbrains.exposed.sql.Database

fun initArisuDB(url: String, username: String, password: String) = Database.connect(
    // 有里栖に接続する情報を記載する。
    url = url,
    driver = "org.postgresql.Driver",
    user = username,
    password = password
)
