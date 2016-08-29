/*   1:    */ package yahoofinance.quotes.stock;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ import java.util.Calendar;
/*   5:    */ import java.util.TimeZone;
/*   6:    */ import yahoofinance.Utils;
/*   7:    */ 
/*   8:    */ public class StockQuote
/*   9:    */ {
/*  10:    */   private final String symbol;
/*  11:    */   private TimeZone timeZone;
/*  12:    */   private BigDecimal ask;
/*  13:    */   private int askSize;
/*  14:    */   private BigDecimal bid;
/*  15:    */   private int bidSize;
/*  16:    */   private BigDecimal price;
/*  17:    */   private int lastTradeSize;
/*  18:    */   private String lastTradeDateStr;
/*  19:    */   private String lastTradeTimeStr;
/*  20:    */   private Calendar lastTradeTime;
/*  21:    */   private BigDecimal open;
/*  22:    */   private BigDecimal previousClose;
/*  23:    */   private BigDecimal dayLow;
/*  24:    */   private BigDecimal dayHigh;
/*  25:    */   private BigDecimal yearLow;
/*  26:    */   private BigDecimal yearHigh;
/*  27:    */   private BigDecimal priceAvg50;
/*  28:    */   private BigDecimal priceAvg200;
/*  29:    */   private long volume;
/*  30:    */   private long avgVolume;
/*  31:    */   
/*  32:    */   public StockQuote(String symbol)
/*  33:    */   {
/*  34: 44 */     this.symbol = symbol;
/*  35:    */   }
/*  36:    */   
/*  37:    */   public BigDecimal getChange()
/*  38:    */   {
/*  39: 52 */     return this.price.subtract(this.previousClose);
/*  40:    */   }
/*  41:    */   
/*  42:    */   public BigDecimal getChangeInPercent()
/*  43:    */   {
/*  44: 60 */     return Utils.getPercent(getChange(), this.previousClose);
/*  45:    */   }
/*  46:    */   
/*  47:    */   public BigDecimal getChangeFromYearLow()
/*  48:    */   {
/*  49: 68 */     return this.price.subtract(this.yearLow);
/*  50:    */   }
/*  51:    */   
/*  52:    */   public BigDecimal getChangeFromYearLowInPercent()
/*  53:    */   {
/*  54: 76 */     return Utils.getPercent(getChangeFromYearLow(), this.yearLow);
/*  55:    */   }
/*  56:    */   
/*  57:    */   public BigDecimal getChangeFromYearHigh()
/*  58:    */   {
/*  59: 84 */     return this.price.subtract(this.yearHigh);
/*  60:    */   }
/*  61:    */   
/*  62:    */   public BigDecimal getChangeFromYearHighInPercent()
/*  63:    */   {
/*  64: 92 */     return Utils.getPercent(getChangeFromYearHigh(), this.yearHigh);
/*  65:    */   }
/*  66:    */   
/*  67:    */   public BigDecimal getChangeFromAvg50()
/*  68:    */   {
/*  69:100 */     return this.price.subtract(this.priceAvg50);
/*  70:    */   }
/*  71:    */   
/*  72:    */   public BigDecimal getChangeFromAvg50InPercent()
/*  73:    */   {
/*  74:108 */     return Utils.getPercent(getChangeFromAvg50(), this.priceAvg50);
/*  75:    */   }
/*  76:    */   
/*  77:    */   public BigDecimal getChangeFromAvg200()
/*  78:    */   {
/*  79:116 */     return this.price.subtract(this.priceAvg200);
/*  80:    */   }
/*  81:    */   
/*  82:    */   public BigDecimal getChangeFromAvg200InPercent()
/*  83:    */   {
/*  84:124 */     return Utils.getPercent(getChangeFromAvg200(), this.priceAvg200);
/*  85:    */   }
/*  86:    */   
/*  87:    */   public String getSymbol()
/*  88:    */   {
/*  89:128 */     return this.symbol;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public BigDecimal getAsk()
/*  93:    */   {
/*  94:132 */     return this.ask;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public void setAsk(BigDecimal ask)
/*  98:    */   {
/*  99:136 */     this.ask = ask;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public int getAskSize()
/* 103:    */   {
/* 104:140 */     return this.askSize;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public void setAskSize(int askSize)
/* 108:    */   {
/* 109:144 */     this.askSize = askSize;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public BigDecimal getBid()
/* 113:    */   {
/* 114:148 */     return this.bid;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public void setBid(BigDecimal bid)
/* 118:    */   {
/* 119:152 */     this.bid = bid;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public int getBidSize()
/* 123:    */   {
/* 124:156 */     return this.bidSize;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public void setBidSize(int bidSize)
/* 128:    */   {
/* 129:160 */     this.bidSize = bidSize;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public BigDecimal getPrice()
/* 133:    */   {
/* 134:164 */     return this.price;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public void setPrice(BigDecimal price)
/* 138:    */   {
/* 139:168 */     this.price = price;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public int getLastTradeSize()
/* 143:    */   {
/* 144:172 */     return this.lastTradeSize;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public void setLastTradeSize(int lastTradeSize)
/* 148:    */   {
/* 149:176 */     this.lastTradeSize = lastTradeSize;
/* 150:    */   }
/* 151:    */   
/* 152:    */   public String getLastTradeDateStr()
/* 153:    */   {
/* 154:180 */     return this.lastTradeDateStr;
/* 155:    */   }
/* 156:    */   
/* 157:    */   public void setLastTradeDateStr(String lastTradeDateStr)
/* 158:    */   {
/* 159:184 */     this.lastTradeDateStr = lastTradeDateStr;
/* 160:    */   }
/* 161:    */   
/* 162:    */   public String getLastTradeTimeStr()
/* 163:    */   {
/* 164:188 */     return this.lastTradeTimeStr;
/* 165:    */   }
/* 166:    */   
/* 167:    */   public void setLastTradeTimeStr(String lastTradeTimeStr)
/* 168:    */   {
/* 169:192 */     this.lastTradeTimeStr = lastTradeTimeStr;
/* 170:    */   }
/* 171:    */   
/* 172:    */   public Calendar getLastTradeTime()
/* 173:    */   {
/* 174:202 */     return this.lastTradeTime;
/* 175:    */   }
/* 176:    */   
/* 177:    */   public void setLastTradeTime(Calendar lastTradeTime)
/* 178:    */   {
/* 179:206 */     this.lastTradeTime = lastTradeTime;
/* 180:    */   }
/* 181:    */   
/* 182:    */   public Calendar getLastTradeTime(TimeZone timeZone)
/* 183:    */   {
/* 184:217 */     return Utils.parseDateTime(this.lastTradeDateStr, this.lastTradeTimeStr, timeZone);
/* 185:    */   }
/* 186:    */   
/* 187:    */   public TimeZone getTimeZone()
/* 188:    */   {
/* 189:221 */     return this.timeZone;
/* 190:    */   }
/* 191:    */   
/* 192:    */   public void setTimeZone(TimeZone timeZone)
/* 193:    */   {
/* 194:225 */     this.timeZone = timeZone;
/* 195:    */   }
/* 196:    */   
/* 197:    */   public BigDecimal getOpen()
/* 198:    */   {
/* 199:229 */     return this.open;
/* 200:    */   }
/* 201:    */   
/* 202:    */   public void setOpen(BigDecimal open)
/* 203:    */   {
/* 204:233 */     this.open = open;
/* 205:    */   }
/* 206:    */   
/* 207:    */   public BigDecimal getPreviousClose()
/* 208:    */   {
/* 209:237 */     return this.previousClose;
/* 210:    */   }
/* 211:    */   
/* 212:    */   public void setPreviousClose(BigDecimal previousClose)
/* 213:    */   {
/* 214:241 */     this.previousClose = previousClose;
/* 215:    */   }
/* 216:    */   
/* 217:    */   public BigDecimal getDayLow()
/* 218:    */   {
/* 219:245 */     return this.dayLow;
/* 220:    */   }
/* 221:    */   
/* 222:    */   public void setDayLow(BigDecimal dayLow)
/* 223:    */   {
/* 224:249 */     this.dayLow = dayLow;
/* 225:    */   }
/* 226:    */   
/* 227:    */   public BigDecimal getDayHigh()
/* 228:    */   {
/* 229:253 */     return this.dayHigh;
/* 230:    */   }
/* 231:    */   
/* 232:    */   public void setDayHigh(BigDecimal dayHigh)
/* 233:    */   {
/* 234:257 */     this.dayHigh = dayHigh;
/* 235:    */   }
/* 236:    */   
/* 237:    */   public BigDecimal getYearLow()
/* 238:    */   {
/* 239:261 */     return this.yearLow;
/* 240:    */   }
/* 241:    */   
/* 242:    */   public void setYearLow(BigDecimal yearLow)
/* 243:    */   {
/* 244:265 */     this.yearLow = yearLow;
/* 245:    */   }
/* 246:    */   
/* 247:    */   public BigDecimal getYearHigh()
/* 248:    */   {
/* 249:269 */     return this.yearHigh;
/* 250:    */   }
/* 251:    */   
/* 252:    */   public void setYearHigh(BigDecimal yearHigh)
/* 253:    */   {
/* 254:273 */     this.yearHigh = yearHigh;
/* 255:    */   }
/* 256:    */   
/* 257:    */   public BigDecimal getPriceAvg50()
/* 258:    */   {
/* 259:281 */     return this.priceAvg50;
/* 260:    */   }
/* 261:    */   
/* 262:    */   public void setPriceAvg50(BigDecimal priceAvg50)
/* 263:    */   {
/* 264:285 */     this.priceAvg50 = priceAvg50;
/* 265:    */   }
/* 266:    */   
/* 267:    */   public BigDecimal getPriceAvg200()
/* 268:    */   {
/* 269:293 */     return this.priceAvg200;
/* 270:    */   }
/* 271:    */   
/* 272:    */   public void setPriceAvg200(BigDecimal priceAvg200)
/* 273:    */   {
/* 274:297 */     this.priceAvg200 = priceAvg200;
/* 275:    */   }
/* 276:    */   
/* 277:    */   public long getVolume()
/* 278:    */   {
/* 279:301 */     return this.volume;
/* 280:    */   }
/* 281:    */   
/* 282:    */   public void setVolume(long volume)
/* 283:    */   {
/* 284:305 */     this.volume = volume;
/* 285:    */   }
/* 286:    */   
/* 287:    */   public long getAvgVolume()
/* 288:    */   {
/* 289:309 */     return this.avgVolume;
/* 290:    */   }
/* 291:    */   
/* 292:    */   public void setAvgVolume(long avgVolume)
/* 293:    */   {
/* 294:313 */     this.avgVolume = avgVolume;
/* 295:    */   }
/* 296:    */   
/* 297:    */   public String toString()
/* 298:    */   {
/* 299:318 */     return "Ask: " + this.ask + ", Bid: " + this.bid + ", Price: " + this.price + ", Prev close: " + this.previousClose;
/* 300:    */   }
/* 301:    */ }


/* Location:           C:\Users\Mike\Desktop\YahooFinanceAPI-1.4.0.jar
 * Qualified Name:     yahoofinance.quotes.stock.StockQuote
 * JD-Core Version:    0.7.0.1
 */