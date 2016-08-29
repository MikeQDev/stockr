/*   1:    */ package yahoofinance.quotes.stock;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ import yahoofinance.Utils;
/*   5:    */ 
/*   6:    */ public class StockStats
/*   7:    */ {
/*   8:    */   private final String symbol;
/*   9:    */   private BigDecimal marketCap;
/*  10:    */   private long sharesFloat;
/*  11:    */   private long sharesOutstanding;
/*  12:    */   private long sharesOwned;
/*  13:    */   private BigDecimal eps;
/*  14:    */   private BigDecimal pe;
/*  15:    */   private BigDecimal peg;
/*  16:    */   private BigDecimal epsEstimateCurrentYear;
/*  17:    */   private BigDecimal epsEstimateNextQuarter;
/*  18:    */   private BigDecimal epsEstimateNextYear;
/*  19:    */   private BigDecimal priceBook;
/*  20:    */   private BigDecimal priceSales;
/*  21:    */   private BigDecimal bookValuePerShare;
/*  22:    */   private BigDecimal revenue;
/*  23:    */   private BigDecimal EBITDA;
/*  24:    */   private BigDecimal oneYearTargetPrice;
/*  25:    */   
/*  26:    */   public StockStats(String symbol)
/*  27:    */   {
/*  28: 38 */     this.symbol = symbol;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public BigDecimal getROE()
/*  32:    */   {
/*  33: 42 */     return Utils.getPercent(this.EBITDA, this.marketCap);
/*  34:    */   }
/*  35:    */   
/*  36:    */   public String getSymbol()
/*  37:    */   {
/*  38: 46 */     return this.symbol;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public BigDecimal getMarketCap()
/*  42:    */   {
/*  43: 50 */     return this.marketCap;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public void setMarketCap(BigDecimal marketCap)
/*  47:    */   {
/*  48: 54 */     this.marketCap = marketCap;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public long getSharesFloat()
/*  52:    */   {
/*  53: 58 */     return this.sharesFloat;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public void setSharesFloat(long sharesFloat)
/*  57:    */   {
/*  58: 62 */     this.sharesFloat = sharesFloat;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public long getSharesOutstanding()
/*  62:    */   {
/*  63: 66 */     return this.sharesOutstanding;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void setSharesOutstanding(long sharesOutstanding)
/*  67:    */   {
/*  68: 70 */     this.sharesOutstanding = sharesOutstanding;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public long getSharesOwned()
/*  72:    */   {
/*  73: 74 */     return this.sharesOwned;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public void setSharesOwned(long sharesOwned)
/*  77:    */   {
/*  78: 78 */     this.sharesOwned = sharesOwned;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public BigDecimal getEps()
/*  82:    */   {
/*  83: 82 */     return this.eps;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public void setEps(BigDecimal eps)
/*  87:    */   {
/*  88: 86 */     this.eps = eps;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public BigDecimal getPe()
/*  92:    */   {
/*  93: 90 */     return this.pe;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public void setPe(BigDecimal pe)
/*  97:    */   {
/*  98: 94 */     this.pe = pe;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public BigDecimal getPeg()
/* 102:    */   {
/* 103: 98 */     return this.peg;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public void setPeg(BigDecimal peg)
/* 107:    */   {
/* 108:102 */     this.peg = peg;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public BigDecimal getEpsEstimateCurrentYear()
/* 112:    */   {
/* 113:106 */     return this.epsEstimateCurrentYear;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public void setEpsEstimateCurrentYear(BigDecimal epsEstimateCurrentYear)
/* 117:    */   {
/* 118:110 */     this.epsEstimateCurrentYear = epsEstimateCurrentYear;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public BigDecimal getEpsEstimateNextQuarter()
/* 122:    */   {
/* 123:114 */     return this.epsEstimateNextQuarter;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public void setEpsEstimateNextQuarter(BigDecimal epsEstimateNextQuarter)
/* 127:    */   {
/* 128:118 */     this.epsEstimateNextQuarter = epsEstimateNextQuarter;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public BigDecimal getEpsEstimateNextYear()
/* 132:    */   {
/* 133:122 */     return this.epsEstimateNextYear;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public void setEpsEstimateNextYear(BigDecimal epsEstimateNextYear)
/* 137:    */   {
/* 138:126 */     this.epsEstimateNextYear = epsEstimateNextYear;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public BigDecimal getPriceBook()
/* 142:    */   {
/* 143:130 */     return this.priceBook;
/* 144:    */   }
/* 145:    */   
/* 146:    */   public void setPriceBook(BigDecimal priceBook)
/* 147:    */   {
/* 148:134 */     this.priceBook = priceBook;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public BigDecimal getPriceSales()
/* 152:    */   {
/* 153:138 */     return this.priceSales;
/* 154:    */   }
/* 155:    */   
/* 156:    */   public void setPriceSales(BigDecimal priceSales)
/* 157:    */   {
/* 158:142 */     this.priceSales = priceSales;
/* 159:    */   }
/* 160:    */   
/* 161:    */   public BigDecimal getBookValuePerShare()
/* 162:    */   {
/* 163:146 */     return this.bookValuePerShare;
/* 164:    */   }
/* 165:    */   
/* 166:    */   public void setBookValuePerShare(BigDecimal bookValuePerShare)
/* 167:    */   {
/* 168:150 */     this.bookValuePerShare = bookValuePerShare;
/* 169:    */   }
/* 170:    */   
/* 171:    */   public BigDecimal getRevenue()
/* 172:    */   {
/* 173:154 */     return this.revenue;
/* 174:    */   }
/* 175:    */   
/* 176:    */   public void setRevenue(BigDecimal revenue)
/* 177:    */   {
/* 178:158 */     this.revenue = revenue;
/* 179:    */   }
/* 180:    */   
/* 181:    */   public BigDecimal getEBITDA()
/* 182:    */   {
/* 183:162 */     return this.EBITDA;
/* 184:    */   }
/* 185:    */   
/* 186:    */   public void setEBITDA(BigDecimal EBITDA)
/* 187:    */   {
/* 188:166 */     this.EBITDA = EBITDA;
/* 189:    */   }
/* 190:    */   
/* 191:    */   public BigDecimal getOneYearTargetPrice()
/* 192:    */   {
/* 193:170 */     return this.oneYearTargetPrice;
/* 194:    */   }
/* 195:    */   
/* 196:    */   public void setOneYearTargetPrice(BigDecimal oneYearTargetPrice)
/* 197:    */   {
/* 198:174 */     this.oneYearTargetPrice = oneYearTargetPrice;
/* 199:    */   }
/* 200:    */   
/* 201:    */   public String toString()
/* 202:    */   {
/* 203:179 */     return "EPS: " + this.eps + ", PE: " + this.pe + ", PEG: " + this.peg;
/* 204:    */   }
/* 205:    */ }


/* Location:           C:\Users\Mike\Desktop\YahooFinanceAPI-1.4.0.jar
 * Qualified Name:     yahoofinance.quotes.stock.StockStats
 * JD-Core Version:    0.7.0.1
 */