package data;

import lombok.Value;

public class DataHelper {

        @Value
        public static class CardInfo {
            String number;
            String month;
            String year;
            String holder;
            String cvc;
        }

        public static CardInfo getCardStatusApproved () {
            return new CardInfo("4444 4444 4444 4441", "05", "23", "Ivanov Ivan", "123");
        }

        public static CardInfo getCardStatusDeclined () {
            return new CardInfo("4444 4444 4444 4442", "11", "22", "Ivanov Ivan", "123");
        }

        //Проверка поля "номер карты"
        public static CardInfo getCardNumberUnknown () {
            return new CardInfo("4444 4444 4444 4443", "11", "22", "Ivanov Ivan", "123");
        }

        public static CardInfo getCardNumberEmptyField () {
            return new CardInfo("", "11", "22", "Ivanov Ivan", "123");
        }

        public static CardInfo getCardNumber15Numerals () {
            return new CardInfo("4444 4444 4444 443", "11", "22", "Ivanov Ivan", "123");
        }

        public static CardInfo getCardNumberZeros () {
            return new CardInfo("0000 0000 0000 0000", "11", "22", "Ivanov Ivan", "123");
        }

        public static CardInfo getCardNumberText () {
            return new CardInfo("ТексTecst", "11", "22", "Ivanov Ivan", "123");
        }

        public static CardInfo getCardNumberSymbols () {
            return new CardInfo("/,:%", "11", "22", "Ivanov Ivan", "123");
        }

        //Проверка поля "месяц"
        public static CardInfo getCardMonthEmptyField () {
            return new CardInfo("4444 4444 4444 4441", "", "22", "Ivanov Ivan", "123");
        }

        public static CardInfo getCardMonthOneNumeral () {
            return new CardInfo("4444 4444 4444 4441", "3", "22", "Ivanov Ivan", "123");
        }

        public static CardInfo getCardMonthZeros () {
            return new CardInfo("4444 4444 4444 4441", "00", "23", "Ivanov Ivan", "123");
        }

        public static CardInfo getCardMonthLetters () {
            return new CardInfo("4444 4444 4444 4441", "Sы", "22", "Ivanov Ivan", "123");
        }

        public static CardInfo getCardMonthSymbols () {
            return new CardInfo("4444 4444 4444 4441", ":%", "22", "Ivanov Ivan", "123");
        }

        public static CardInfo getCardMonthOver12 () {
            return new CardInfo("4444 4444 4444 4441", "13", "22", "Ivanov Ivan", "123");
        }

        //Проверка поля "год"
        public static CardInfo getCardYearEmptyField () {
            return new CardInfo("4444 4444 4444 4441", "10", "", "Ivanov Ivan", "123");
        }

        public static CardInfo getCardYearOneNumeral () {
            return new CardInfo("4444 4444 4444 4441", "10", "3", "Ivanov Ivan", "123");
        }

        public static CardInfo getCardYearZeros () {
            return new CardInfo("4444 4444 4444 4441", "10", "00", "Ivanov Ivan", "123");
        }

        public static CardInfo getCardYearOver27 () {
            return new CardInfo("4444 4444 4444 4441", "10", "45", "Ivanov Ivan", "123");
        }

        public static CardInfo getCardYearLess22 () {
            return new CardInfo("4444 4444 4444 4441", "10", "20", "Ivanov Ivan", "123");
        }

        public static CardInfo getCardYearText () {
            return new CardInfo("4444 4444 4444 4441", "10", "Фt", "Ivanov Ivan", "123");
        }

        public static CardInfo getCardYearSymbols () {
            return new CardInfo("4444 4444 4444 4441", "10", "/%", "Ivanov Ivan", "123");
        }

        //Проверка поля "Владелец"
        public static CardInfo getCardHolderEmptyField () {
            return new CardInfo("4444 4444 4444 4441", "05", "23", "", "123");
        }

        public static CardInfo getCardHolderNoName () {
            return new CardInfo("4444 4444 4444 4441", "05", "23", "Ivanov", "123");
        }

        public static CardInfo getCardHolderThreeNames () {
            return new CardInfo("4444 4444 4444 4441", "05", "23", "Ivanov Ivan Ivan", "123");
        }

        public static CardInfo getCardHolderCyrillic () {
            return new CardInfo("4444 4444 4444 4441", "05", "23", "Иванов Иван", "123");
        }

        public static CardInfo getCardHolderNumeral () {
            return new CardInfo("4444 4444 4444 4441", "05", "23", "55587 8888", "123");
        }

        public static CardInfo getCardHolderLettersAndNumbers () {
            return new CardInfo("4444 4444 4444 4441", "05", "23", "Ivanov56 Ivan", "123");
        }

        public static CardInfo getCardHolderLettersAndSymbols () {
            return new CardInfo("4444 4444 4444 4441", "05", "23", "Ivanov& Ivan", "123");
        }

        //Проверка поля "CVC/CVV"
        public static CardInfo getCardCvcEmptyField () {
            return new CardInfo("4444 4444 4444 4441", "05", "23", "Ivanov Ivan", "");
        }

        public static CardInfo getCardCvcZeros () {
            return new CardInfo("4444 4444 4444 4441", "05", "23", "Ivanov Ivan", "000");
        }

        public static CardInfo getCardCvcOneDigit () {
            return new CardInfo("4444 4444 4444 4441", "05", "23", "Ivanov Ivan", "1");
        }

        public static CardInfo getCardCvcTwoDigit () {
            return new CardInfo("4444 4444 4444 4441", "05", "23", "Ivanov Ivan", "23");
        }

        public static CardInfo getCardCvcLetters () {
            return new CardInfo("4444 4444 4444 4441", "05", "23", "Ivanov Ivan", "ТSы");
        }

        public static CardInfo getCardCvcSymbols () {
            return new CardInfo("4444 4444 4444 4441", "05", "23", "Ivanov Ivan", "/:%");
        }

        //все поля пустые
        public static CardInfo getCardAllFieldsEmpty () {
            return new CardInfo("", "", "", "", "");
        }
    }