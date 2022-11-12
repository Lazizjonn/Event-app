package uz.gita.eventapp_slp

fun <T> T.scope(block: T.() -> Unit) {
    block(this)
}