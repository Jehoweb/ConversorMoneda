package com.conversor.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MonedaEnum {
    AED(1,"AED","UAE Dirham","United Arab Emirates"),
    AFN(2,"AFN","Afghan Afghani","Afghanistan"),
    ALL(3,"ALL","Albanian Lek","Albania"),
    AMD(4,"AMD","Armenian Dram","Armenia"),
    ANG(5,"ANG","Netherlands Antillian Guilder","Netherlands Antilles"),
    AOA(6,"AOA","Angolan Kwanza","Angola"),
    ARS(7,"ARS","Argentine Peso","Argentina"),
    AUD(8,"AUD","Australian Dollar","Australia"),
    AWG(9,"AWG","Aruban Florin","Aruba"),
    AZN(10,"AZN","Azerbaijani Manat","Azerbaijan"),
    BAM(11,"BAM","Bosnia and Herzegovina Mark","Bosnia and Herzegovina"),
    BBD(12,"BBD","Barbados Dollar","Barbados"),
    BDT(13,"BDT","Bangladeshi Taka","Bangladesh"),
    BGN(14,"BGN","Bulgarian Lev","Bulgaria"),
    BHD(15,"BHD","Bahraini Dinar","Bahrain"),
    BIF(16,"BIF","Burundian Franc","Burundi"),
    BMD(17,"BMD","Bermudian Dollar","Bermuda"),
    BND(18,"BND","Brunei Dollar","Brunei"),
    BOB(19,"BOB","Bolivian Boliviano","Bolivia"),
    BRL(20,"BRL","Brazilian Real","Brazil"),
    BSD(21,"BSD","Bahamian Dollar","Bahamas"),
    BTN(22,"BTN","Bhutanese Ngultrum","Bhutan"),
    BWP(23,"BWP","Botswana Pula","Botswana"),
    BYN(24,"BYN","Belarusian Ruble","Belarus"),
    BZD(25,"BZD","Belize Dollar","Belize"),
    CAD(26,"CAD","Canadian Dollar","Canada"),
    CDF(27,"CDF","Congolese Franc","Democratic Republic of the Congo"),
    CHF(28,"CHF","Swiss Franc","Switzerland"),
    CLP(29,"CLP","Chilean Peso","Chile"),
    CNY(30,"CNY","Chinese Renminbi","China"),
    COP(31,"COP","Colombian Peso","Colombia"),
    CRC(32,"CRC","Costa Rican Colon","Costa Rica"),
    CUP(33,"CUP","Cuban Peso","Cuba"),
    CVE(34,"CVE","Cape Verdean Escudo","Cape Verde"),
    CZK(35,"CZK","Czech Koruna","Czech Republic"),
    DJF(36,"DJF","Djiboutian Franc","Djibouti"),
    DKK(37,"DKK","Danish Krone","Denmark"),
    DOP(38,"DOP","Dominican Peso","Dominican Republic"),
    DZD(39,"DZD","Algerian Dinar","Algeria"),
    EGP(40,"EGP","Egyptian Pound","Egypt"),
    ERN(41,"ERN","Eritrean Nakfa","Eritrea"),
    ETB(42,"ETB","Ethiopian Birr","Ethiopia"),
    EUR(43,"EUR","Euro","European Union"),
    FJD(44,"FJD","Fiji Dollar","Fiji"),
    FKP(45,"FKP","Falkland Islands Pound","Falkland Islands"),
    FOK(46,"FOK","Faroese Króna","Faroe Islands"),
    GBP(47,"GBP","Pound Sterling","United Kingdom"),
    GEL(48,"GEL","Georgian Lari","Georgia"),
    GGP(49,"GGP","Guernsey Pound","Guernsey"),
    GHS(50,"GHS","Ghanaian Cedi","Ghana"),
    GIP(51,"GIP","Gibraltar Pound","Gibraltar"),
    GMD(52,"GMD","Gambian Dalasi","The Gambia"),
    GNF(53,"GNF","Guinean Franc","Guinea"),
    GTQ(54,"GTQ","Guatemalan Quetzal","Guatemala"),
    GYD(55,"GYD","Guyanese Dollar","Guyana"),
    HKD(56,"HKD","Hong Kong Dollar","Hong Kong"),
    HNL(57,"HNL","Honduran Lempira","Honduras"),
    HRK(58,"HRK","Croatian Kuna","Croatia"),
    HTG(59,"HTG","Haitian Gourde","Haiti"),
    HUF(60,"HUF","Hungarian Forint","Hungary"),
    IDR(61,"IDR","Indonesian Rupiah","Indonesia"),
    ILS(62,"ILS","Israeli New Shekel","Israel"),
    IMP(63,"IMP","Manx Pound","Isle of Man"),
    INR(64,"INR","Indian Rupee","India"),
    IQD(65,"IQD","Iraqi Dinar","Iraq"),
    IRR(66,"IRR","Iranian Rial","Iran"),
    ISK(67,"ISK","Icelandic Króna","Iceland"),
    JEP(68,"JEP","Jersey Pound","Jersey"),
    JMD(69,"JMD","Jamaican Dollar","Jamaica"),
    JOD(70,"JOD","Jordanian Dinar","Jordan"),
    JPY(71,"JPY","Japanese Yen","Japan"),
    KES(72,"KES","Kenyan Shilling","Kenya"),
    KGS(73,"KGS","Kyrgyzstani Som","Kyrgyzstan"),
    KHR(74,"KHR","Cambodian Riel","Cambodia"),
    KID(75,"KID","Kiribati Dollar","Kiribati"),
    KMF(76,"KMF","Comorian Franc","Comoros"),
    KRW(77,"KRW","South Korean Won","South Korea"),
    KWD(78,"KWD","Kuwaiti Dinar","Kuwait"),
    KYD(79,"KYD","Cayman Islands Dollar","Cayman Islands"),
    KZT(80,"KZT","Kazakhstani Tenge","Kazakhstan"),
    LAK(81,"LAK","Lao Kip","Laos"),
    LBP(82,"LBP","Lebanese Pound","Lebanon"),
    LKR(83,"LKR","Sri Lanka Rupee","Sri Lanka"),
    LRD(84,"LRD","Liberian Dollar","Liberia"),
    LSL(85,"LSL","Lesotho Loti","Lesotho"),
    LYD(86,"LYD","Libyan Dinar","Libya"),
    MAD(87,"MAD","Moroccan Dirham","Morocco"),
    MDL(88,"MDL","Moldovan Leu","Moldova"),
    MGA(89,"MGA","Malagasy Ariary","Madagascar"),
    MKD(90,"MKD","Macedonian Denar","North Macedonia"),
    MMK(91,"MMK","Burmese Kyat","Myanmar"),
    MNT(92,"MNT","Mongolian Tögrög","Mongolia"),
    MOP(93,"MOP","Macanese Pataca","Macau"),
    MRU(94,"MRU","Mauritanian Ouguiya","Mauritania"),
    MUR(95,"MUR","Mauritian Rupee","Mauritius"),
    MVR(96,"MVR","Maldivian Rufiyaa","Maldives"),
    MWK(97,"MWK","Malawian Kwacha","Malawi"),
    MXN(98,"MXN","Mexican Peso","Mexico"),
    MYR(99,"MYR","Malaysian Ringgit","Malaysia"),
    MZN(100,"MZN","Mozambican Metical","Mozambique"),
    NAD(101,"NAD","Namibian Dollar","Namibia"),
    NGN(102,"NGN","Nigerian Naira","Nigeria"),
    NIO(103,"NIO","Nicaraguan Córdoba","Nicaragua"),
    NOK(104,"NOK","Norwegian Krone","Norway"),
    NPR(105,"NPR","Nepalese Rupee","Nepal"),
    NZD(106,"NZD","New Zealand Dollar","New Zealand"),
    OMR(107,"OMR","Omani Rial","Oman"),
    PAB(108,"PAB","Panamanian Balboa","Panama"),
    PEN(109,"PEN","Peruvian Sol","Peru"),
    PGK(110,"PGK","Papua New Guinean Kina","Papua New Guinea"),
    PHP(111,"PHP","Philippine Peso","Philippines"),
    PKR(112,"PKR","Pakistani Rupee","Pakistan"),
    PLN(113,"PLN","Polish Złoty","Poland"),
    PYG(114,"PYG","Paraguayan Guaraní","Paraguay"),
    QAR(115,"QAR","Qatari Riyal","Qatar"),
    RON(116,"RON","Romanian Leu","Romania"),
    RSD(117,"RSD","Serbian Dinar","Serbia"),
    RUB(118,"RUB","Russian Ruble","Russia"),
    RWF(119,"RWF","Rwandan Franc","Rwanda"),
    SAR(120,"SAR","Saudi Riyal","Saudi Arabia"),
    SBD(121,"SBD","Solomon Islands Dollar","Solomon Islands"),
    SCR(122,"SCR","Seychellois Rupee","Seychelles"),
    SDG(123,"SDG","Sudanese Pound","Sudan"),
    SEK(124,"SEK","Swedish Krona","Sweden"),
    SGD(125,"SGD","Singapore Dollar","Singapore"),
    SHP(126,"SHP","Saint Helena Pound","Saint Helena"),
    SLE(127,"SLE","Sierra Leonean Leone","Sierra Leone"),
    SLL(128,"SLL","Leones de Sierra Leona","Sierra Leona Leona"),
    SOS(129,"SOS","Somali Shilling","Somalia"),
    SRD(130,"SRD","Surinamese Dollar","Suriname"),
    SSP(131,"SSP","South Sudanese Pound","South Sudan"),
    STN(132,"STN","São Tomé and Príncipe Dobra","São Tomé and Príncipe"),
    SYP(133,"SYP","Syrian Pound","Syria"),
    SZL(134,"SZL","Eswatini Lilangeni","Eswatini"),
    THB(135,"THB","Thai Baht","Thailand"),
    TJS(136,"TJS","Tajikistani Somoni","Tajikistan"),
    TMT(137,"TMT","Turkmenistan Manat","Turkmenistan"),
    TND(138,"TND","Tunisian Dinar","Tunisia"),
    TOP(139,"TOP","Tongan Paʻanga","Tonga"),
    TRY(140,"TRY","Turkish Lira","Turkey"),
    TTD(141,"TTD","Trinidad and Tobago Dollar","Trinidad and Tobago"),
    TVD(142,"TVD","Tuvaluan Dollar","Tuvalu"),
    TWD(143,"TWD","New Taiwan Dollar","Taiwan"),
    TZS(144,"TZS","Tanzanian Shilling","Tanzania"),
    UAH(145,"UAH","Ukrainian Hryvnia","Ukraine"),
    UGX(146,"UGX","Ugandan Shilling","Uganda"),
    USD(147,"USD","United States Dollar","United States"),
    UYU(148,"UYU","Uruguayan Peso","Uruguay"),
    UZS(149,"UZS","Uzbekistani So'm","Uzbekistan"),
    VES(150,"VES","Venezuelan Bolívar Soberano","Venezuela"),
    VND(151,"VND","Vietnamese Đồng","Vietnam"),
    VUV(152,"VUV","Vanuatu Vatu","Vanuatu"),
    WST(153,"WST","Samoan Tālā","Samoa"),
    XAF(154,"XAF","Central African CFA Franc","CEMAC"),
    XCD(155,"XCD","East Caribbean Dollar","Organisation of Eastern Caribbean States"),
    XDR(156,"XDR","Special Drawing Rights","International Monetary Fund"),
    XOF(157,"XOF","West African CFA franc","CFA"),
    XPF(158,"XPF","CFP Franc","Collectivités d'Outre-Mer"),
    YER(159,"YER","Yemeni Rial","Yemen"),
    ZAR(160,"ZAR","South African Rand","South Africa"),
    ZMW(161,"ZMW","Zambian Kwacha","Zambia"),
    ZWL(162,"ZWL","Zimbabwean Dollar","Zimbabwe");


    private final int id;
    private final String codigo;
    private final String nombre;
    private final String pais;

    MonedaEnum(int idt, String clave, String nombreDiv, String pais){
        this.id= idt;
        this.codigo=clave;
        this.nombre=nombreDiv;
        this.pais=pais;
    }

    public int getId(){ return this.id; }
    public String getCodigo(){ return this.codigo; }
    public String getNombre(){ return this.nombre; }
    public String getPais() { return this.pais; }
    public  MonedaEnum  getMonedaPorClave(String codigoDivisa){
        MonedaEnum divisaEnum = null;
        for(MonedaEnum mnd: MonedaEnum.values()){
            if(mnd.getCodigo().equals(codigoDivisa)){
                divisaEnum = mnd;
                break;
            }
        }
        return divisaEnum;
    }

    public static MonedaEnum  getMonedaPorId(Integer iduni){
        MonedaEnum moneda= null;
        for (MonedaEnum e: MonedaEnum.values()) {
            if(e.getId() == iduni.intValue()){
                moneda = e;
                break;
            }
        }
        return moneda;
    }

    public static List<MonedaEnum> getDivisas(){
        List<MonedaEnum> divisas = new ArrayList<>();
        divisas = Arrays.stream(MonedaEnum.values()).collect(Collectors.toList());
        return divisas;
    }

    public static Stream< MonedaEnum > flujoDivisa() {
        return Stream.of(MonedaEnum.values());
    }

    public static int getNumeroDivisas(){
        int contador=0;
        for(MonedaEnum mnd: MonedaEnum.values()){
            contador = contador + 1;
        }
        return contador;
    }
}
