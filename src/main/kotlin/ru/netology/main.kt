package ru.netology

fun main() {
    val cardType = "Vk Pay" // Vk Pay, Mastercard, Maestro, Visa, Мир

    val transfer = 85_000_00 // в копейках
    val transferMonth = 0

    val totalTransferMaster = mastercardAndMaestro(transfer = transfer, transferMonth = transferMonth)
    val totalTransferVisa = visaAndMir(transfer = transfer, transferMonth = transferMonth)
    val totalVkPay = vkPay(transfer = transfer, transferMonth = transferMonth)

    val result = when (cardType) {
        "Mastercard", "Maestro" -> totalTransferMaster
        "Visa", "Мир" -> totalTransferVisa
        "Vk Pay" -> totalVkPay
        else -> "Такая карта не принимается"
    }
    print(result)
}

fun mastercardAndMaestro(transfer: Int, transferMonth: Int): String =
    when {
        transfer > 150_000_00 || transferMonth > 600_000_00
        -> "Вы превысили лимит по переводам"
        transfer < 75_000_00 -> "Комиссия за перевод составит 0 копеек"
        else -> "Комиссия за перевод составит ${(transfer / 1000) * 6 + 20_00} копеек"
    }

fun visaAndMir(transfer: Int, transferMonth: Int): String =
    when {
        transfer > 150_000_00 || transferMonth > 600_000_00 -> "Вы превысили лимит по переводам"
        (transfer / 10000 * 75) < 35_00 -> "Комиссия за перевод составит 3500 копеек"
        else -> "Комиссия за перевод составит ${transfer / 10000 * 75} копеек"
    }

fun vkPay(transfer: Int, transferMonth: Int): String =
    when {
        transfer > 15_000_00 || transferMonth > 40_000_00 -> "Вы превысили лимит по переводам"
        else -> "Комиссия за перевод составит 0 копеек"
    }