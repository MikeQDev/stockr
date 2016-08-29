/*   1:    */ package yahoofinance;
/*   2:    */ 
/*   3:    */ import java.io.UnsupportedEncodingException;
/*   4:    */ import java.math.BigDecimal;
/*   5:    */ import java.net.URLEncoder;
/*   6:    */ import java.text.ParseException;
/*   7:    */ import java.text.SimpleDateFormat;
/*   8:    */ import java.util.Calendar;
/*   9:    */ import java.util.Locale;
/*  10:    */ import java.util.Map;
/*  11:    */ import java.util.Map.Entry;
/*  12:    */ import java.util.TimeZone;
/*  13:    */ import java.util.logging.Level;
/*  14:    */ import java.util.logging.Logger;
/*  15:    */ 
/*  16:    */ public class Utils
/*  17:    */ {
/*  18: 21 */   public static final BigDecimal HUNDRED = new BigDecimal(100);
/*  19: 22 */   public static final BigDecimal THOUSAND = new BigDecimal(1000);
/*  20: 23 */   public static final BigDecimal MILLION = new BigDecimal(1000000);
/*  21: 24 */   public static final BigDecimal BILLION = new BigDecimal(1000000000);
/*  22:    */   
/*  23:    */   public static String join(String[] data, String d)
/*  24:    */   {
/*  25: 27 */     if (data.length == 0) {
/*  26: 28 */       return "";
/*  27:    */     }
/*  28: 30 */     StringBuilder sb = new StringBuilder();
/*  29: 33 */     for (int i = 0; i < data.length - 1; i++) {
/*  30: 34 */       sb.append(data[i]).append(d);
/*  31:    */     }
/*  32: 36 */     return data[i];
/*  33:    */   }
/*  34:    */   
/*  35:    */   private static String cleanNumberString(String data)
/*  36:    */   {
/*  37: 40 */     return join(data.trim().split(","), "");
/*  38:    */   }
/*  39:    */   
/*  40:    */   private static boolean isParseable(String data)
/*  41:    */   {
/*  42: 44 */     return (data != null) && (!data.equals("N/A")) && (!data.equals("-")) && (!data.equals(""));
/*  43:    */   }
/*  44:    */   
/*  45:    */   public static BigDecimal getBigDecimal(String data)
/*  46:    */   {
/*  47: 48 */     BigDecimal result = BigDecimal.ZERO;
/*  48: 49 */     if (!isParseable(data)) {
/*  49: 50 */       return result;
/*  50:    */     }
/*  51:    */     try
/*  52:    */     {
/*  53: 53 */       data = cleanNumberString(data);
/*  54: 54 */       char lastChar = data.charAt(data.length() - 1);
/*  55: 55 */       BigDecimal multiplier = BigDecimal.ONE;
/*  56: 56 */       switch (lastChar)
/*  57:    */       {
/*  58:    */       case 'B': 
/*  59: 58 */         data = data.substring(0, data.length() - 1);
/*  60: 59 */         multiplier = BILLION;
/*  61: 60 */         break;
/*  62:    */       case 'M': 
/*  63: 62 */         data = data.substring(0, data.length() - 1);
/*  64: 63 */         multiplier = MILLION;
/*  65: 64 */         break;
/*  66:    */       case 'K': 
/*  67: 66 */         data = data.substring(0, data.length() - 1);
/*  68: 67 */         multiplier = THOUSAND;
/*  69:    */       }
/*  70: 70 */       result = new BigDecimal(data).multiply(multiplier);
/*  71:    */     }
/*  72:    */     catch (NumberFormatException e)
/*  73:    */     {
/*  74: 72 */       YahooFinance.logger.log(Level.INFO, "Failed to parse: " + data, e);
/*  75:    */     }
/*  76: 74 */     return result;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public static BigDecimal getBigDecimal(String dataMain, String dataSub)
/*  80:    */   {
/*  81: 78 */     BigDecimal main = getBigDecimal(dataMain);
/*  82: 79 */     BigDecimal sub = getBigDecimal(dataSub);
/*  83: 80 */     if (main.compareTo(BigDecimal.ZERO) == 0) {
/*  84: 81 */       return sub;
/*  85:    */     }
/*  86: 83 */     return main;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public static double getDouble(String data)
/*  90:    */   {
/*  91: 87 */     double result = 0.0D;
/*  92: 88 */     if (!isParseable(data)) {
/*  93: 89 */       return result;
/*  94:    */     }
/*  95:    */     try
/*  96:    */     {
/*  97: 92 */       data = cleanNumberString(data);
/*  98: 93 */       char lastChar = data.charAt(data.length() - 1);
/*  99: 94 */       int multiplier = 1;
/* 100: 95 */       switch (lastChar)
/* 101:    */       {
/* 102:    */       case 'B': 
/* 103: 97 */         data = data.substring(0, data.length() - 1);
/* 104: 98 */         multiplier = 1000000000;
/* 105: 99 */         break;
/* 106:    */       case 'M': 
/* 107:101 */         data = data.substring(0, data.length() - 1);
/* 108:102 */         multiplier = 1000000;
/* 109:103 */         break;
/* 110:    */       case 'K': 
/* 111:105 */         data = data.substring(0, data.length() - 1);
/* 112:106 */         multiplier = 1000;
/* 113:    */       }
/* 114:109 */       result = Double.parseDouble(data) * multiplier;
/* 115:    */     }
/* 116:    */     catch (NumberFormatException e)
/* 117:    */     {
/* 118:111 */       YahooFinance.logger.log(Level.INFO, "Failed to parse: " + data, e);
/* 119:    */     }
/* 120:113 */     return result;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public static int getInt(String data)
/* 124:    */   {
/* 125:117 */     int result = 0;
/* 126:118 */     if (!isParseable(data)) {
/* 127:119 */       return result;
/* 128:    */     }
/* 129:    */     try
/* 130:    */     {
/* 131:122 */       data = cleanNumberString(data);
/* 132:123 */       result = Integer.parseInt(data);
/* 133:    */     }
/* 134:    */     catch (NumberFormatException e)
/* 135:    */     {
/* 136:125 */       YahooFinance.logger.log(Level.INFO, "Failed to parse: " + data, e);
/* 137:    */     }
/* 138:127 */     return result;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public static long getLong(String data)
/* 142:    */   {
/* 143:131 */     long result = 0L;
/* 144:132 */     if (!isParseable(data)) {
/* 145:133 */       return result;
/* 146:    */     }
/* 147:    */     try
/* 148:    */     {
/* 149:136 */       data = cleanNumberString(data);
/* 150:137 */       result = Long.parseLong(data);
/* 151:    */     }
/* 152:    */     catch (NumberFormatException e)
/* 153:    */     {
/* 154:139 */       YahooFinance.logger.log(Level.INFO, "Failed to parse: " + data, e);
/* 155:    */     }
/* 156:141 */     return result;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public static BigDecimal getPercent(BigDecimal numerator, BigDecimal denominator)
/* 160:    */   {
/* 161:145 */     if (denominator.compareTo(BigDecimal.ZERO) == 0) {
/* 162:146 */       return BigDecimal.ZERO;
/* 163:    */     }
/* 164:149 */     return numerator.divide(denominator, 4, 6).multiply(HUNDRED).setScale(2, 6);
/* 165:    */   }
/* 166:    */   
/* 167:    */   public static double getPercent(double numerator, double denominator)
/* 168:    */   {
/* 169:153 */     if (denominator == 0.0D) {
/* 170:154 */       return 0.0D;
/* 171:    */     }
/* 172:156 */     return numerator / denominator * 100.0D;
/* 173:    */   }
/* 174:    */   
/* 175:    */   private static String getDividendDateFormat(String date)
/* 176:    */   {
/* 177:160 */     if (date.matches("[0-9][0-9]-...-[0-9][0-9]")) {
/* 178:161 */       return "dd-MMM-yy";
/* 179:    */     }
/* 180:162 */     if (date.matches("[0-9]-...-[0-9][0-9]")) {
/* 181:163 */       return "d-MMM-yy";
/* 182:    */     }
/* 183:164 */     if (date.matches("...[ ]+[0-9]+")) {
/* 184:165 */       return "MMM d";
/* 185:    */     }
/* 186:167 */     return "M/d/yy";
/* 187:    */   }
/* 188:    */   
/* 189:    */   public static Calendar parseDividendDate(String date)
/* 190:    */   {
/* 191:179 */     if (!isParseable(date)) {
/* 192:180 */       return null;
/* 193:    */     }
/* 194:182 */     date = date.trim();
/* 195:183 */     SimpleDateFormat format = new SimpleDateFormat(getDividendDateFormat(date), Locale.US);
/* 196:184 */     format.setTimeZone(TimeZone.getTimeZone("America/New_York"));
/* 197:    */     try
/* 198:    */     {
/* 199:186 */       Calendar today = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
/* 200:187 */       Calendar parsedDate = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
/* 201:188 */       parsedDate.setTime(format.parse(date));
/* 202:190 */       if (parsedDate.get(1) == 1970)
/* 203:    */       {
/* 204:192 */         int monthDiff = parsedDate.get(2) - today.get(2);
/* 205:193 */         int year = today.get(1);
/* 206:194 */         if (monthDiff > 6) {
/* 207:195 */           year--;
/* 208:196 */         } else if (monthDiff < -6) {
/* 209:197 */           year++;
/* 210:    */         }
/* 211:199 */         parsedDate.set(1, year);
/* 212:    */       }
/* 213:202 */       return parsedDate;
/* 214:    */     }
/* 215:    */     catch (ParseException ex)
/* 216:    */     {
/* 217:204 */       YahooFinance.logger.log(Level.SEVERE, ex.getMessage(), ex);
/* 218:    */     }
/* 219:205 */     return null;
/* 220:    */   }
/* 221:    */   
/* 222:    */   public static Calendar parseDateTime(String date, String time, TimeZone timeZone)
/* 223:    */   {
/* 224:219 */     String datetime = date + " " + time;
/* 225:220 */     SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy h:mma", Locale.US);
/* 226:    */     
/* 227:222 */     format.setTimeZone(timeZone);
/* 228:    */     try
/* 229:    */     {
/* 230:224 */       if ((isParseable(date)) && (isParseable(time)))
/* 231:    */       {
/* 232:225 */         Calendar c = Calendar.getInstance();
/* 233:226 */         c.setTime(format.parse(datetime));
/* 234:227 */         return c;
/* 235:    */       }
/* 236:    */     }
/* 237:    */     catch (ParseException ex)
/* 238:    */     {
/* 239:230 */       YahooFinance.logger.log(Level.SEVERE, ex.getMessage(), ex);
/* 240:    */     }
/* 241:232 */     return null;
/* 242:    */   }
/* 243:    */   
/* 244:    */   public static Calendar parseHistDate(String date)
/* 245:    */   {
/* 246:236 */     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
/* 247:237 */     format.setTimeZone(TimeZone.getTimeZone("America/New_York"));
/* 248:    */     try
/* 249:    */     {
/* 250:239 */       if (isParseable(date))
/* 251:    */       {
/* 252:240 */         Calendar c = Calendar.getInstance();
/* 253:241 */         c.setTime(format.parse(date));
/* 254:242 */         return c;
/* 255:    */       }
/* 256:    */     }
/* 257:    */     catch (ParseException ex)
/* 258:    */     {
/* 259:245 */       YahooFinance.logger.log(Level.SEVERE, ex.getMessage(), ex);
/* 260:    */     }
/* 261:247 */     return null;
/* 262:    */   }
/* 263:    */   
/* 264:    */   public static String getURLParameters(Map<String, String> params)
/* 265:    */   {
/* 266:251 */     StringBuilder sb = new StringBuilder();
/* 267:253 */     for (Map.Entry<String, String> entry : params.entrySet())
/* 268:    */     {
/* 269:254 */       if (sb.length() > 0) {
/* 270:255 */         sb.append("&");
/* 271:    */       }
/* 272:257 */       String key = (String)entry.getKey();
/* 273:258 */       String value = (String)entry.getValue();
/* 274:    */       try
/* 275:    */       {
/* 276:260 */         key = URLEncoder.encode(key, "UTF-8");
/* 277:261 */         value = URLEncoder.encode(value, "UTF-8");
/* 278:    */       }
/* 279:    */       catch (UnsupportedEncodingException ex)
/* 280:    */       {
/* 281:263 */         YahooFinance.logger.log(Level.SEVERE, ex.getMessage(), ex);
/* 282:    */       }
/* 283:266 */       sb.append(String.format("%s=%s", new Object[] { key, value }));
/* 284:    */     }
/* 285:268 */     return sb.toString();
/* 286:    */   }
/* 287:    */   
/* 288:    */   public static String stripOverhead(String line)
/* 289:    */   {
/* 290:279 */     return line.replaceAll("\"", "");
/* 291:    */   }
/* 292:    */   
/* 293:    */   public static String unescape(String data)
/* 294:    */   {
/* 295:283 */     StringBuilder buffer = new StringBuilder(data.length());
/* 296:284 */     for (int i = 0; i < data.length(); i++) {
/* 297:285 */       if (data.charAt(i) > 'Ā') {
/* 298:286 */         buffer.append("\\u").append(Integer.toHexString(data.charAt(i)));
/* 299:288 */       } else if (data.charAt(i) == '\n') {
/* 300:289 */         buffer.append("\\n");
/* 301:290 */       } else if (data.charAt(i) == '\t') {
/* 302:291 */         buffer.append("\\t");
/* 303:292 */       } else if (data.charAt(i) == '\r') {
/* 304:293 */         buffer.append("\\r");
/* 305:294 */       } else if (data.charAt(i) == '\b') {
/* 306:295 */         buffer.append("\\b");
/* 307:296 */       } else if (data.charAt(i) == '\f') {
/* 308:297 */         buffer.append("\\f");
/* 309:298 */       } else if (data.charAt(i) == '\'') {
/* 310:299 */         buffer.append("\\'");
/* 311:300 */       } else if (data.charAt(i) == '"') {
/* 312:301 */         buffer.append("\\\"");
/* 313:302 */       } else if (data.charAt(i) == '\\') {
/* 314:303 */         buffer.append("\\\\");
/* 315:    */       } else {
/* 316:305 */         buffer.append(data.charAt(i));
/* 317:    */       }
/* 318:    */     }
/* 319:309 */     return buffer.toString();
/* 320:    */   }
/* 321:    */ }


/* Location:           C:\Users\Mike\Desktop\YahooFinanceAPI-1.4.0.jar
 * Qualified Name:     yahoofinance.Utils
 * JD-Core Version:    0.7.0.1
 */