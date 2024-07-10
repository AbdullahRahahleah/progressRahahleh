package com.Rahahleh.fxAnalyzer.tools;

public enum CurrencyEnum {
    AED(1), AFN(2), ALL(3), AMD(4), ANG(5), AOA(6), ARS(7), AUD(8), AWG(9), AZN(10),
    BAM(11), BBD(12), BDT(13), BGN(14), BHD(15), BIF(16), BMD(17), BND(18), BOB(19), BRL(20),
    BSD(21), BTN(22), BWP(23), BYN(24), BZD(25), CAD(26), CDF(27), CHF(28), CLP(29), CNY(30),
    COP(31), CRC(32), CUP(33), CVE(34), CZK(35), DJF(36), DKK(37), DOP(38), DZD(39), EGP(40),
    ERN(41), ETB(42), EUR(43), FJD(44), FKP(45), FOK(46), GBP(47), GEL(48), GGP(49), GHS(50),
    GIP(51), GMD(52), GNF(53), GTQ(54), GYD(55), HKD(56), HNL(57), HRK(58), HTG(59), HUF(60),
    IDR(61), ILS(62), IMP(63), INR(64), IQD(65), IRR(66), ISK(67), JEP(68), JMD(69), JOD(70),
    JPY(71), KES(72), KGS(73), KHR(74), KID(75), KMF(76), KPW(77), KRW(78), KWD(79), KYD(80),
    KZT(81), LAK(82), LBP(83), LKR(84), LRD(85), LSL(86), LYD(87), MAD(88), MDL(89), MGA(90),
    MKD(91), MMK(92), MNT(93), MOP(94), MRU(95), MUR(96), MVR(97), MWK(98), MXN(99), MYR(100),
    MZN(101), NAD(102), NGN(103), NIO(104), NOK(105), NPR(106), NZD(107), OMR(108), PAB(109), PEN(110),
    PGK(111), PHP(112), PKR(113), PLN(114), PYG(115), QAR(116), RON(117), RSD(118), RUB(119), RWF(120),
    SAR(121), SBD(122), SCR(123), SDG(124), SEK(125), SGD(126), SHP(127), SLL(128), SOS(129), SRD(130),
    SSP(131), STN(132), SYP(133), SZL(134), THB(135), TJS(136), TMT(137), TND(138), TOP(139), TRY(140),
    TTD(141), TVD(142), TWD(143), TZS(144), UAH(145), UGX(146), USD(147), UYU(148), UZS(149), VES(150),
    VND(151), VUV(152), WST(153), XAF(154), XCD(155), XDR(156), XOF(157), XPF(158), YER(159), ZAR(160),
    ZMW(161);

    private final int id;
    public static final String [] allValues =new String[CurrencyEnum.values().length];

    CurrencyEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public static CurrencyEnum getById(int id) {
        for (CurrencyEnum currency : CurrencyEnum.values()) {
            if (currency.id == id) {
                return currency;
            }
        }
        throw new IllegalArgumentException("No currency found with id: " + id);
    }
    public static String[] getAllValues(){
        if(allValues==null){
            int index=0;
            for(CurrencyEnum currencyEnum:values()){
                allValues[index] = currencyEnum.name();
                index++;
            }
        }
        return allValues;
    }
}
