package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun mastercardAndMaestro_transferFixedCommissionTest() {
        // arrange
        val transfer = 15_000_00
        val transferMonth = 0
        val expectedResult = "Комиссия за перевод составит 0 копеек"
        // act
        val result = mastercardAndMaestro(
            transfer = transfer,
            transferMonth = transferMonth
        )
        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun mastercardAndMaestro_transferPercentCommissionTest() {
        // arrange
        val transfer = 85_000_00
        val transferMonth = 0
        val expectedResult = "Комиссия за перевод составит ${(transfer / 1000) * 6 + 20_00} копеек"
        // act
        val result = mastercardAndMaestro(
            transfer = transfer,
            transferMonth = transferMonth
        )
        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun mastercardAndMaestro_transferLimitTest() {
        // arrange
        val transfer = 505_000_00
        val transferMonth = 905_000_00
        val expectedResult = "Вы превысили лимит по переводам"
        // act
        val result = mastercardAndMaestro(
            transfer = transfer,
            transferMonth = transferMonth
        )
        // assert
        assertEquals(expectedResult, result)

    }


    @Test
    fun visaAndMir_transferFixedCommissionTest() {
        // arrange
        val transfer = 100_00
        val transferMonth = 0
        val expectedResult = "Комиссия за перевод составит 3500 копеек"
        // act
        val result = visaAndMir(
            transfer = transfer,
            transferMonth = transferMonth
        )
        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun visaAndMir_transferPercentCommissionTest() {
        // arrange
        val transfer = 85_000_00
        val transferMonth = 0
        val expectedResult = "Комиссия за перевод составит ${transfer / 10000 * 75} копеек"
        // act
        val result = visaAndMir(
            transfer = transfer,
            transferMonth = transferMonth
        )
        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun visaAndMir_transferLimitTest() {
        // arrange
        val transfer = 805_000_00
        val transferMonth = 905_000_00
        val expectedResult = "Вы превысили лимит по переводам"
        // act
        val result = visaAndMir(
            transfer = transfer,
            transferMonth = transferMonth
        )
        // assert
        assertEquals(expectedResult, result)
    }


    @Test
    fun vkPay_transferAddTest() {
        // arrange
        val transfer = 5_000_00
        val transferMonth = 0
        val expectedResult = "Комиссия за перевод составит 0 копеек"
        // act
        val result = vkPay(
            transfer = transfer,
            transferMonth = transferMonth
        )
        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun vkPay_transferLimitTest() {
        // arrange
        val transfer = 505_000_00
        val transferMonth = 905_000_00
        val expectedResult = "Вы превысили лимит по переводам"
        // act
        val result = vkPay(
            transfer = transfer,
            transferMonth = transferMonth
        )
        // assert
        assertEquals(expectedResult, result)
    }
}