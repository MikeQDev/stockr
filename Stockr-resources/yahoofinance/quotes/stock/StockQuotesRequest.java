/*   1:    */ package yahoofinance.quotes.stock;
/*   2:    */ 
/*   3:    */ import java.util.ArrayList;
/*   4:    */ import java.util.List;
/*   5:    */ import yahoofinance.quotes.QuotesProperty;
/*   6:    */ import yahoofinance.quotes.QuotesRequest;
/*   7:    */ 
/*   8:    */ public class StockQuotesRequest
/*   9:    */   extends QuotesRequest<StockQuotesData>
/*  10:    */ {
/*  11: 26 */   public static final List<QuotesProperty> DEFAULT_PROPERTIES = new ArrayList();
/*  12:    */   
/*  13:    */   static
/*  14:    */   {
/*  15: 31 */     DEFAULT_PROPERTIES.add(QuotesProperty.Name);
/*  16: 32 */     DEFAULT_PROPERTIES.add(QuotesProperty.Symbol);
/*  17:    */     
/*  18: 34 */     DEFAULT_PROPERTIES.add(QuotesProperty.Currency);
/*  19: 35 */     DEFAULT_PROPERTIES.add(QuotesProperty.StockExchange);
/*  20:    */     
/*  21: 37 */     DEFAULT_PROPERTIES.add(QuotesProperty.Ask);
/*  22: 38 */     DEFAULT_PROPERTIES.add(QuotesProperty.AskRealtime);
/*  23: 39 */     DEFAULT_PROPERTIES.add(QuotesProperty.Symbol);
/*  24: 40 */     DEFAULT_PROPERTIES.add(QuotesProperty.AskSize);
/*  25: 41 */     DEFAULT_PROPERTIES.add(QuotesProperty.Symbol);
/*  26: 42 */     DEFAULT_PROPERTIES.add(QuotesProperty.Bid);
/*  27: 43 */     DEFAULT_PROPERTIES.add(QuotesProperty.BidRealtime);
/*  28: 44 */     DEFAULT_PROPERTIES.add(QuotesProperty.Symbol);
/*  29: 45 */     DEFAULT_PROPERTIES.add(QuotesProperty.BidSize);
/*  30: 46 */     DEFAULT_PROPERTIES.add(QuotesProperty.Symbol);
/*  31:    */     
/*  32: 48 */     DEFAULT_PROPERTIES.add(QuotesProperty.LastTradePriceOnly);
/*  33: 49 */     DEFAULT_PROPERTIES.add(QuotesProperty.Symbol);
/*  34: 50 */     DEFAULT_PROPERTIES.add(QuotesProperty.LastTradeSize);
/*  35: 51 */     DEFAULT_PROPERTIES.add(QuotesProperty.Symbol);
/*  36: 52 */     DEFAULT_PROPERTIES.add(QuotesProperty.LastTradeDate);
/*  37: 53 */     DEFAULT_PROPERTIES.add(QuotesProperty.LastTradeTime);
/*  38:    */     
/*  39: 55 */     DEFAULT_PROPERTIES.add(QuotesProperty.Open);
/*  40: 56 */     DEFAULT_PROPERTIES.add(QuotesProperty.PreviousClose);
/*  41: 57 */     DEFAULT_PROPERTIES.add(QuotesProperty.DaysLow);
/*  42: 58 */     DEFAULT_PROPERTIES.add(QuotesProperty.DaysHigh);
/*  43:    */     
/*  44: 60 */     DEFAULT_PROPERTIES.add(QuotesProperty.Volume);
/*  45: 61 */     DEFAULT_PROPERTIES.add(QuotesProperty.AverageDailyVolume);
/*  46:    */     
/*  47: 63 */     DEFAULT_PROPERTIES.add(QuotesProperty.YearHigh);
/*  48: 64 */     DEFAULT_PROPERTIES.add(QuotesProperty.YearLow);
/*  49:    */     
/*  50: 66 */     DEFAULT_PROPERTIES.add(QuotesProperty.FiftydayMovingAverage);
/*  51: 67 */     DEFAULT_PROPERTIES.add(QuotesProperty.TwoHundreddayMovingAverage);
/*  52:    */     
/*  53: 69 */     DEFAULT_PROPERTIES.add(QuotesProperty.Symbol);
/*  54: 70 */     DEFAULT_PROPERTIES.add(QuotesProperty.SharesOutstanding);
/*  55: 71 */     DEFAULT_PROPERTIES.add(QuotesProperty.Symbol);
/*  56: 72 */     DEFAULT_PROPERTIES.add(QuotesProperty.Symbol);
/*  57: 73 */     DEFAULT_PROPERTIES.add(QuotesProperty.SharesOwned);
/*  58: 74 */     DEFAULT_PROPERTIES.add(QuotesProperty.Symbol);
/*  59: 75 */     DEFAULT_PROPERTIES.add(QuotesProperty.MarketCapitalization);
/*  60: 76 */     DEFAULT_PROPERTIES.add(QuotesProperty.Symbol);
/*  61: 77 */     DEFAULT_PROPERTIES.add(QuotesProperty.SharesFloat);
/*  62: 78 */     DEFAULT_PROPERTIES.add(QuotesProperty.Symbol);
/*  63:    */     
/*  64: 80 */     DEFAULT_PROPERTIES.add(QuotesProperty.DividendPayDate);
/*  65: 81 */     DEFAULT_PROPERTIES.add(QuotesProperty.ExDividendDate);
/*  66: 82 */     DEFAULT_PROPERTIES.add(QuotesProperty.TrailingAnnualDividendYield);
/*  67: 83 */     DEFAULT_PROPERTIES.add(QuotesProperty.TrailingAnnualDividendYieldInPercent);
/*  68:    */     
/*  69: 85 */     DEFAULT_PROPERTIES.add(QuotesProperty.DilutedEPS);
/*  70: 86 */     DEFAULT_PROPERTIES.add(QuotesProperty.EPSEstimateCurrentYear);
/*  71: 87 */     DEFAULT_PROPERTIES.add(QuotesProperty.EPSEstimateNextQuarter);
/*  72: 88 */     DEFAULT_PROPERTIES.add(QuotesProperty.EPSEstimateNextYear);
/*  73: 89 */     DEFAULT_PROPERTIES.add(QuotesProperty.PERatio);
/*  74: 90 */     DEFAULT_PROPERTIES.add(QuotesProperty.PEGRatio);
/*  75:    */     
/*  76: 92 */     DEFAULT_PROPERTIES.add(QuotesProperty.PriceBook);
/*  77: 93 */     DEFAULT_PROPERTIES.add(QuotesProperty.PriceSales);
/*  78: 94 */     DEFAULT_PROPERTIES.add(QuotesProperty.BookValuePerShare);
/*  79:    */     
/*  80: 96 */     DEFAULT_PROPERTIES.add(QuotesProperty.Revenue);
/*  81: 97 */     DEFAULT_PROPERTIES.add(QuotesProperty.EBITDA);
/*  82: 98 */     DEFAULT_PROPERTIES.add(QuotesProperty.OneyrTargetPrice);
/*  83:    */   }
/*  84:    */   
/*  85:    */   public StockQuotesRequest(String query)
/*  86:    */   {
/*  87:103 */     super(query, DEFAULT_PROPERTIES);
/*  88:    */   }
/*  89:    */   
/*  90:    */   protected StockQuotesData parseCSVLine(String line)
/*  91:    */   {
/*  92:108 */     List<String> parsedLine = new ArrayList();
/*  93:    */     
/*  94:    */ 
/*  95:111 */     int pos1 = 0;
/*  96:112 */     int pos2 = 0;
/*  97:113 */     int skip = 2;
/*  98:115 */     if (line.startsWith("\""))
/*  99:    */     {
/* 100:116 */       pos1 = 1;
/* 101:117 */       pos2 = line.indexOf('"', 1);
/* 102:    */     }
/* 103:    */     else
/* 104:    */     {
/* 105:119 */       pos2 = line.indexOf(",\"");
/* 106:120 */       skip = 1;
/* 107:    */     }
/* 108:123 */     String name = line.substring(pos1, pos2);
/* 109:124 */     pos1 = pos2 + skip;
/* 110:125 */     pos2 = line.indexOf('"', pos1 + 1);
/* 111:126 */     String fullSymbol = line.substring(pos1, pos2 + 1);
/* 112:127 */     String symbol = fullSymbol.substring(1, fullSymbol.length() - 1);
/* 113:    */     
/* 114:129 */     parsedLine.add(name);
/* 115:130 */     parsedLine.add(symbol);
/* 116:132 */     for (pos1 = pos2 + 2; pos1 < line.length(); pos1++) {
/* 117:134 */       if (line.startsWith(fullSymbol, pos1))
/* 118:    */       {
/* 119:135 */         parsedLine.add(symbol);
/* 120:136 */         pos1 = pos1 + fullSymbol.length() + 1;
/* 121:137 */         pos2 = line.indexOf(fullSymbol, pos1) - 1;
/* 122:138 */         parsedLine.add(line.substring(pos1, pos2));
/* 123:139 */         parsedLine.add(symbol);
/* 124:140 */         pos1 = pos2 + fullSymbol.length() + 1;
/* 125:    */       }
/* 126:141 */       else if (line.charAt(pos1) == '"')
/* 127:    */       {
/* 128:142 */         pos1++;
/* 129:143 */         pos2 = line.indexOf('"', pos1);
/* 130:144 */         parsedLine.add(line.substring(pos1, pos2));
/* 131:145 */         pos1 = pos2 + 1;
/* 132:    */       }
/* 133:146 */       else if (line.charAt(pos1) != ',')
/* 134:    */       {
/* 135:147 */         pos2 = line.indexOf(',', pos1);
/* 136:148 */         if (pos2 <= pos1) {
/* 137:149 */           pos2 = line.length();
/* 138:    */         }
/* 139:151 */         parsedLine.add(line.substring(pos1, pos2));
/* 140:152 */         pos1 = pos2;
/* 141:    */       }
/* 142:    */     }
/* 143:155 */     return new StockQuotesData((String[])parsedLine.toArray(new String[this.properties.size()]));
/* 144:    */   }
/* 145:    */ }


/* Location:           C:\Users\Mike\Desktop\YahooFinanceAPI-1.4.0.jar
 * Qualified Name:     yahoofinance.quotes.stock.StockQuotesRequest
 * JD-Core Version:    0.7.0.1
 */