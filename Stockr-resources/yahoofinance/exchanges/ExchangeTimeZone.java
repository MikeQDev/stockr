/*   1:    */ package yahoofinance.exchanges;
/*   2:    */ 
/*   3:    */ import java.util.HashMap;
/*   4:    */ import java.util.Map;
/*   5:    */ import java.util.TimeZone;
/*   6:    */ import java.util.logging.Level;
/*   7:    */ import java.util.logging.Logger;
/*   8:    */ import yahoofinance.YahooFinance;
/*   9:    */ 
/*  10:    */ public class ExchangeTimeZone
/*  11:    */ {
/*  12: 17 */   public static final Map<String, TimeZone> SUFFIX_TIMEZONES = new HashMap();
/*  13: 18 */   public static final Map<String, TimeZone> INDEX_TIMEZONES = new HashMap();
/*  14:    */   
/*  15:    */   static
/*  16:    */   {
/*  17: 21 */     SUFFIX_TIMEZONES.put("", TimeZone.getTimeZone("America/New_York"));
/*  18: 22 */     SUFFIX_TIMEZONES.put("CBT", TimeZone.getTimeZone("America/New_York"));
/*  19: 23 */     SUFFIX_TIMEZONES.put("CME", TimeZone.getTimeZone("America/New_York"));
/*  20: 24 */     SUFFIX_TIMEZONES.put("NYB", TimeZone.getTimeZone("America/New_York"));
/*  21: 25 */     SUFFIX_TIMEZONES.put("CMX", TimeZone.getTimeZone("America/New_York"));
/*  22: 26 */     SUFFIX_TIMEZONES.put("NYM", TimeZone.getTimeZone("America/New_York"));
/*  23: 27 */     SUFFIX_TIMEZONES.put("OB", TimeZone.getTimeZone("America/New_York"));
/*  24: 28 */     SUFFIX_TIMEZONES.put("PK", TimeZone.getTimeZone("America/New_York"));
/*  25: 29 */     SUFFIX_TIMEZONES.put("BA", TimeZone.getTimeZone("America/Buenos_Aires"));
/*  26: 30 */     SUFFIX_TIMEZONES.put("VI", TimeZone.getTimeZone("Europe/Vienna"));
/*  27: 31 */     SUFFIX_TIMEZONES.put("AX", TimeZone.getTimeZone("Australia/ACT"));
/*  28: 32 */     SUFFIX_TIMEZONES.put("SA", TimeZone.getTimeZone("America/Sao_Paulo"));
/*  29: 33 */     SUFFIX_TIMEZONES.put("TO", TimeZone.getTimeZone("America/Toronto"));
/*  30: 34 */     SUFFIX_TIMEZONES.put("V", TimeZone.getTimeZone("America/Toronto"));
/*  31: 35 */     SUFFIX_TIMEZONES.put("SN", TimeZone.getTimeZone("America/Santiago"));
/*  32: 36 */     SUFFIX_TIMEZONES.put("SS", TimeZone.getTimeZone("Asia/Shanghai"));
/*  33: 37 */     SUFFIX_TIMEZONES.put("SZ", TimeZone.getTimeZone("Asia/Shanghai"));
/*  34: 38 */     SUFFIX_TIMEZONES.put("CO", TimeZone.getTimeZone("Europe/Copenhagen"));
/*  35: 39 */     SUFFIX_TIMEZONES.put("NX", TimeZone.getTimeZone("Europe/Paris"));
/*  36: 40 */     SUFFIX_TIMEZONES.put("PA", TimeZone.getTimeZone("Europe/Paris"));
/*  37: 41 */     SUFFIX_TIMEZONES.put("BE", TimeZone.getTimeZone("Europe/Berlin"));
/*  38: 42 */     SUFFIX_TIMEZONES.put("BM", TimeZone.getTimeZone("Europe/Berlin"));
/*  39: 43 */     SUFFIX_TIMEZONES.put("DU", TimeZone.getTimeZone("Europe/Berlin"));
/*  40: 44 */     SUFFIX_TIMEZONES.put("F", TimeZone.getTimeZone("Europe/Berlin"));
/*  41: 45 */     SUFFIX_TIMEZONES.put("HM", TimeZone.getTimeZone("Europe/Berlin"));
/*  42: 46 */     SUFFIX_TIMEZONES.put("HA", TimeZone.getTimeZone("Europe/Berlin"));
/*  43: 47 */     SUFFIX_TIMEZONES.put("MU", TimeZone.getTimeZone("Europe/Berlin"));
/*  44: 48 */     SUFFIX_TIMEZONES.put("SG", TimeZone.getTimeZone("Europe/Berlin"));
/*  45: 49 */     SUFFIX_TIMEZONES.put("DE", TimeZone.getTimeZone("Europe/Berlin"));
/*  46: 50 */     SUFFIX_TIMEZONES.put("HK", TimeZone.getTimeZone("Asia/Hong_Kong"));
/*  47: 51 */     SUFFIX_TIMEZONES.put("BO", TimeZone.getTimeZone("Asia/Kolkata"));
/*  48: 52 */     SUFFIX_TIMEZONES.put("NS", TimeZone.getTimeZone("Asia/Kolkata"));
/*  49: 53 */     SUFFIX_TIMEZONES.put("JK", TimeZone.getTimeZone("Asia/Jakarta"));
/*  50: 54 */     SUFFIX_TIMEZONES.put("TA", TimeZone.getTimeZone("Asia/Tel_Aviv"));
/*  51: 55 */     SUFFIX_TIMEZONES.put("MI", TimeZone.getTimeZone("Europe/Rome"));
/*  52: 56 */     SUFFIX_TIMEZONES.put("MX", TimeZone.getTimeZone("America/Mexico_City"));
/*  53: 57 */     SUFFIX_TIMEZONES.put("AS", TimeZone.getTimeZone("Europe/Amsterdam"));
/*  54: 58 */     SUFFIX_TIMEZONES.put("NZ", TimeZone.getTimeZone("Pacific/Auckland"));
/*  55: 59 */     SUFFIX_TIMEZONES.put("OL", TimeZone.getTimeZone("Europe/Oslo"));
/*  56: 60 */     SUFFIX_TIMEZONES.put("SI", TimeZone.getTimeZone("Asia/Singapore"));
/*  57: 61 */     SUFFIX_TIMEZONES.put("KS", TimeZone.getTimeZone("Asia/Seoul"));
/*  58: 62 */     SUFFIX_TIMEZONES.put("KQ", TimeZone.getTimeZone("Asia/Seoul"));
/*  59: 63 */     SUFFIX_TIMEZONES.put("BC", TimeZone.getTimeZone("Europe/Madrid"));
/*  60: 64 */     SUFFIX_TIMEZONES.put("BI", TimeZone.getTimeZone("Europe/Madrid"));
/*  61: 65 */     SUFFIX_TIMEZONES.put("MF", TimeZone.getTimeZone("Europe/Madrid"));
/*  62: 66 */     SUFFIX_TIMEZONES.put("MC", TimeZone.getTimeZone("Europe/Madrid"));
/*  63: 67 */     SUFFIX_TIMEZONES.put("MA", TimeZone.getTimeZone("Europe/Madrid"));
/*  64: 68 */     SUFFIX_TIMEZONES.put("ST", TimeZone.getTimeZone("Europe/Stockholm"));
/*  65: 69 */     SUFFIX_TIMEZONES.put("SW", TimeZone.getTimeZone("Europe/Zurich"));
/*  66: 70 */     SUFFIX_TIMEZONES.put("TWO", TimeZone.getTimeZone("Asia/Taipei"));
/*  67: 71 */     SUFFIX_TIMEZONES.put("TW", TimeZone.getTimeZone("Asia/Taipei"));
/*  68: 72 */     SUFFIX_TIMEZONES.put("L", TimeZone.getTimeZone("Europe/London"));
/*  69: 73 */     SUFFIX_TIMEZONES.put("PR", TimeZone.getTimeZone("Europe/Prague"));
/*  70: 74 */     SUFFIX_TIMEZONES.put("ME", TimeZone.getTimeZone("Europe/Moscow"));
/*  71: 75 */     SUFFIX_TIMEZONES.put("AT", TimeZone.getTimeZone("Europe/Athens"));
/*  72:    */     
/*  73: 77 */     INDEX_TIMEZONES.put("^FTSE", TimeZone.getTimeZone("Europe/London"));
/*  74: 78 */     INDEX_TIMEZONES.put("^GDAXI", TimeZone.getTimeZone("Europe/Berlin"));
/*  75: 79 */     INDEX_TIMEZONES.put("^FCHI", TimeZone.getTimeZone("Europe/Paris"));
/*  76: 80 */     INDEX_TIMEZONES.put("^IBEX", TimeZone.getTimeZone("Europe/Madrid"));
/*  77: 81 */     INDEX_TIMEZONES.put("^OMX", TimeZone.getTimeZone("Europe/Stockholm"));
/*  78: 82 */     INDEX_TIMEZONES.put("^OSEAX", TimeZone.getTimeZone("Europe/Oslo"));
/*  79: 83 */     INDEX_TIMEZONES.put("ATX", TimeZone.getTimeZone("America/New_York"));
/*  80: 84 */     INDEX_TIMEZONES.put("^SSMI", TimeZone.getTimeZone("Europe/Zurich"));
/*  81: 85 */     INDEX_TIMEZONES.put("^BFX", TimeZone.getTimeZone("Europe/Brussels"));
/*  82: 86 */     INDEX_TIMEZONES.put("^DJI", TimeZone.getTimeZone("America/New_York"));
/*  83: 87 */     INDEX_TIMEZONES.put("^OEX", TimeZone.getTimeZone("America/New_York"));
/*  84: 88 */     INDEX_TIMEZONES.put("^NDX", TimeZone.getTimeZone("America/New_York"));
/*  85: 89 */     INDEX_TIMEZONES.put("^BATSK", TimeZone.getTimeZone("America/New_York"));
/*  86: 90 */     INDEX_TIMEZONES.put("^N225", TimeZone.getTimeZone("Asia/Tokyo"));
/*  87: 91 */     INDEX_TIMEZONES.put("^HSI", TimeZone.getTimeZone("Asia/Hong_Kong"));
/*  88: 92 */     INDEX_TIMEZONES.put("^STI", TimeZone.getTimeZone("Asia/Singapore"));
/*  89: 93 */     INDEX_TIMEZONES.put("^AORD", TimeZone.getTimeZone("Australia/ACT"));
/*  90: 94 */     INDEX_TIMEZONES.put("^BSESN", TimeZone.getTimeZone("Asia/Kolkata"));
/*  91: 95 */     INDEX_TIMEZONES.put("^JKSE", TimeZone.getTimeZone("Asia/Jakarta"));
/*  92: 96 */     INDEX_TIMEZONES.put("^KLSE", TimeZone.getTimeZone("Asia/Kuala_Lumpur"));
/*  93: 97 */     INDEX_TIMEZONES.put("^NZ50", TimeZone.getTimeZone("Pacific/Auckland"));
/*  94: 98 */     INDEX_TIMEZONES.put("^NSEI", TimeZone.getTimeZone("Asia/Kolkata"));
/*  95: 99 */     INDEX_TIMEZONES.put("^KS11", TimeZone.getTimeZone("Asia/Seoul"));
/*  96:100 */     INDEX_TIMEZONES.put("^TWII", TimeZone.getTimeZone("Asia/Taipei"));
/*  97:101 */     INDEX_TIMEZONES.put("^MERV", TimeZone.getTimeZone("America/Buenos_Aires"));
/*  98:102 */     INDEX_TIMEZONES.put("^BVSP", TimeZone.getTimeZone("America/Sao_Paulo"));
/*  99:103 */     INDEX_TIMEZONES.put("^GSPTSE", TimeZone.getTimeZone("America/Toronto"));
/* 100:104 */     INDEX_TIMEZONES.put("^MXX", TimeZone.getTimeZone("America/Mexico_City"));
/* 101:105 */     INDEX_TIMEZONES.put("^GSPC", TimeZone.getTimeZone("America/New_York"));
/* 102:106 */     INDEX_TIMEZONES.put("^CCSI", TimeZone.getTimeZone("Africa/Cairo"));
/* 103:107 */     INDEX_TIMEZONES.put("^TA100", TimeZone.getTimeZone("Asia/Tel_Aviv"));
/* 104:108 */     INDEX_TIMEZONES.put("^FTMC", TimeZone.getTimeZone("Europe/London"));
/* 105:109 */     INDEX_TIMEZONES.put("^FTLC", TimeZone.getTimeZone("Europe/London"));
/* 106:110 */     INDEX_TIMEZONES.put("^FTAI", TimeZone.getTimeZone("Europe/London"));
/* 107:111 */     INDEX_TIMEZONES.put("^FTAS", TimeZone.getTimeZone("Europe/London"));
/* 108:112 */     INDEX_TIMEZONES.put("^FTSC", TimeZone.getTimeZone("Europe/London"));
/* 109:113 */     INDEX_TIMEZONES.put("^FTT1X", TimeZone.getTimeZone("Europe/London"));
/* 110:114 */     INDEX_TIMEZONES.put("^MID", TimeZone.getTimeZone("America/New_York"));
/* 111:115 */     INDEX_TIMEZONES.put("^SP600", TimeZone.getTimeZone("America/New_York"));
/* 112:116 */     INDEX_TIMEZONES.put("^SPSUPX", TimeZone.getTimeZone("America/New_York"));
/* 113:117 */     INDEX_TIMEZONES.put("^VIX", TimeZone.getTimeZone("America/New_York"));
/* 114:118 */     INDEX_TIMEZONES.put("^DJC", TimeZone.getTimeZone("America/New_York"));
/* 115:119 */     INDEX_TIMEZONES.put("^XAU", TimeZone.getTimeZone("America/New_York"));
/* 116:120 */     INDEX_TIMEZONES.put("^DJT", TimeZone.getTimeZone("America/New_York"));
/* 117:121 */     INDEX_TIMEZONES.put("^DJU", TimeZone.getTimeZone("America/New_York"));
/* 118:122 */     INDEX_TIMEZONES.put("^DJA", TimeZone.getTimeZone("America/New_York"));
/* 119:123 */     INDEX_TIMEZONES.put("^DWCF", TimeZone.getTimeZone("America/New_York"));
/* 120:124 */     INDEX_TIMEZONES.put("^DJU", TimeZone.getTimeZone("America/New_York"));
/* 121:125 */     INDEX_TIMEZONES.put("^IXIC", TimeZone.getTimeZone("America/New_York"));
/* 122:126 */     INDEX_TIMEZONES.put("^BANK", TimeZone.getTimeZone("America/New_York"));
/* 123:127 */     INDEX_TIMEZONES.put("^NBI", TimeZone.getTimeZone("America/New_York"));
/* 124:128 */     INDEX_TIMEZONES.put("^IXCO", TimeZone.getTimeZone("America/New_York"));
/* 125:129 */     INDEX_TIMEZONES.put("^IXF", TimeZone.getTimeZone("America/New_York"));
/* 126:130 */     INDEX_TIMEZONES.put("^INDS", TimeZone.getTimeZone("America/New_York"));
/* 127:131 */     INDEX_TIMEZONES.put("^INSR", TimeZone.getTimeZone("America/New_York"));
/* 128:132 */     INDEX_TIMEZONES.put("^OFIN", TimeZone.getTimeZone("America/New_York"));
/* 129:133 */     INDEX_TIMEZONES.put("^IXTC", TimeZone.getTimeZone("America/New_York"));
/* 130:134 */     INDEX_TIMEZONES.put("^TRAN", TimeZone.getTimeZone("America/New_York"));
/* 131:135 */     INDEX_TIMEZONES.put("^NYA", TimeZone.getTimeZone("America/New_York"));
/* 132:136 */     INDEX_TIMEZONES.put("^NYE", TimeZone.getTimeZone("America/New_York"));
/* 133:137 */     INDEX_TIMEZONES.put("^NYK", TimeZone.getTimeZone("America/New_York"));
/* 134:138 */     INDEX_TIMEZONES.put("^NYP", TimeZone.getTimeZone("America/New_York"));
/* 135:139 */     INDEX_TIMEZONES.put("^NYY", TimeZone.getTimeZone("America/New_York"));
/* 136:140 */     INDEX_TIMEZONES.put("^NYI", TimeZone.getTimeZone("America/New_York"));
/* 137:141 */     INDEX_TIMEZONES.put("^NY", TimeZone.getTimeZone("America/New_York"));
/* 138:142 */     INDEX_TIMEZONES.put("^NYL", TimeZone.getTimeZone("America/New_York"));
/* 139:143 */     INDEX_TIMEZONES.put("^XMI", TimeZone.getTimeZone("America/New_York"));
/* 140:144 */     INDEX_TIMEZONES.put("^XAX", TimeZone.getTimeZone("America/New_York"));
/* 141:145 */     INDEX_TIMEZONES.put("^BATSK", TimeZone.getTimeZone("America/New_York"));
/* 142:146 */     INDEX_TIMEZONES.put("^RUI", TimeZone.getTimeZone("America/New_York"));
/* 143:147 */     INDEX_TIMEZONES.put("^RUT", TimeZone.getTimeZone("America/New_York"));
/* 144:148 */     INDEX_TIMEZONES.put("^RUA", TimeZone.getTimeZone("America/New_York"));
/* 145:149 */     INDEX_TIMEZONES.put("^SOX", TimeZone.getTimeZone("America/New_York"));
/* 146:150 */     INDEX_TIMEZONES.put("^BKX", TimeZone.getTimeZone("America/New_York"));
/* 147:    */   }
/* 148:    */   
/* 149:    */   public static TimeZone get(String suffix)
/* 150:    */   {
/* 151:161 */     if (SUFFIX_TIMEZONES.containsKey(suffix)) {
/* 152:162 */       return (TimeZone)SUFFIX_TIMEZONES.get(suffix);
/* 153:    */     }
/* 154:164 */     YahooFinance.logger.log(Level.WARNING, "Cannot find time zone for exchange suffix: '" + suffix + "'. Using default: America/New_York");
/* 155:165 */     return (TimeZone)SUFFIX_TIMEZONES.get("");
/* 156:    */   }
/* 157:    */   
/* 158:    */   public static TimeZone getStockTimeZone(String symbol)
/* 159:    */   {
/* 160:177 */     if (INDEX_TIMEZONES.containsKey(symbol)) {
/* 161:178 */       return (TimeZone)INDEX_TIMEZONES.get(symbol);
/* 162:    */     }
/* 163:181 */     if (!symbol.contains(".")) {
/* 164:182 */       return get("");
/* 165:    */     }
/* 166:184 */     String[] split = symbol.split("\\.");
/* 167:185 */     return get(split[(split.length - 1)]);
/* 168:    */   }
/* 169:    */ }


/* Location:           C:\Users\Mike\Desktop\YahooFinanceAPI-1.4.0.jar
 * Qualified Name:     yahoofinance.exchanges.ExchangeTimeZone
 * JD-Core Version:    0.7.0.1
 */