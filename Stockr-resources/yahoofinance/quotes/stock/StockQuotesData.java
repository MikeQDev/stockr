/*   1:    */ package yahoofinance.quotes.stock;
/*   2:    */ 
/*   3:    */ import java.util.List;
/*   4:    */ import yahoofinance.Stock;
/*   5:    */ import yahoofinance.Utils;
/*   6:    */ import yahoofinance.exchanges.ExchangeTimeZone;
/*   7:    */ import yahoofinance.quotes.QuotesProperty;
/*   8:    */ 
/*   9:    */ public class StockQuotesData
/*  10:    */ {
/*  11:    */   private final String[] data;
/*  12:    */   
/*  13:    */   public StockQuotesData(String[] data)
/*  14:    */   {
/*  15: 18 */     this.data = data;
/*  16:    */   }
/*  17:    */   
/*  18:    */   public String getValue(QuotesProperty property)
/*  19:    */   {
/*  20: 22 */     int i = StockQuotesRequest.DEFAULT_PROPERTIES.indexOf(property);
/*  21: 23 */     if ((i >= 0) && (i < this.data.length)) {
/*  22: 24 */       return this.data[i];
/*  23:    */     }
/*  24: 26 */     return null;
/*  25:    */   }
/*  26:    */   
/*  27:    */   public StockQuote getQuote()
/*  28:    */   {
/*  29: 30 */     String symbol = getValue(QuotesProperty.Symbol);
/*  30: 31 */     StockQuote quote = new StockQuote(symbol);
/*  31:    */     
/*  32: 33 */     quote.setPrice(Utils.getBigDecimal(getValue(QuotesProperty.LastTradePriceOnly)));
/*  33: 34 */     quote.setLastTradeSize(Utils.getInt(getValue(QuotesProperty.LastTradeSize)));
/*  34: 35 */     quote.setAsk(Utils.getBigDecimal(getValue(QuotesProperty.AskRealtime), getValue(QuotesProperty.Ask)));
/*  35: 36 */     quote.setAskSize(Utils.getInt(getValue(QuotesProperty.AskSize)));
/*  36: 37 */     quote.setBid(Utils.getBigDecimal(getValue(QuotesProperty.BidRealtime), getValue(QuotesProperty.Bid)));
/*  37: 38 */     quote.setBidSize(Utils.getInt(getValue(QuotesProperty.BidSize)));
/*  38: 39 */     quote.setOpen(Utils.getBigDecimal(getValue(QuotesProperty.Open)));
/*  39: 40 */     quote.setPreviousClose(Utils.getBigDecimal(getValue(QuotesProperty.PreviousClose)));
/*  40: 41 */     quote.setDayHigh(Utils.getBigDecimal(getValue(QuotesProperty.DaysHigh)));
/*  41: 42 */     quote.setDayLow(Utils.getBigDecimal(getValue(QuotesProperty.DaysLow)));
/*  42:    */     
/*  43: 44 */     quote.setTimeZone(ExchangeTimeZone.getStockTimeZone(symbol));
/*  44: 45 */     quote.setLastTradeTime(Utils.parseDateTime(getValue(QuotesProperty.LastTradeDate), getValue(QuotesProperty.LastTradeTime), quote.getTimeZone()));
/*  45:    */     
/*  46: 47 */     quote.setYearHigh(Utils.getBigDecimal(getValue(QuotesProperty.YearHigh)));
/*  47: 48 */     quote.setYearLow(Utils.getBigDecimal(getValue(QuotesProperty.YearLow)));
/*  48: 49 */     quote.setPriceAvg50(Utils.getBigDecimal(getValue(QuotesProperty.FiftydayMovingAverage)));
/*  49: 50 */     quote.setPriceAvg200(Utils.getBigDecimal(getValue(QuotesProperty.TwoHundreddayMovingAverage)));
/*  50:    */     
/*  51: 52 */     quote.setVolume(Utils.getLong(getValue(QuotesProperty.Volume)));
/*  52: 53 */     quote.setAvgVolume(Utils.getLong(getValue(QuotesProperty.AverageDailyVolume)));
/*  53:    */     
/*  54: 55 */     return quote;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public StockStats getStats()
/*  58:    */   {
/*  59: 59 */     String symbol = getValue(QuotesProperty.Symbol);
/*  60: 60 */     StockStats stats = new StockStats(symbol);
/*  61:    */     
/*  62: 62 */     stats.setMarketCap(Utils.getBigDecimal(getValue(QuotesProperty.MarketCapitalization)));
/*  63: 63 */     stats.setSharesFloat(Utils.getLong(getValue(QuotesProperty.SharesFloat)));
/*  64: 64 */     stats.setSharesOutstanding(Utils.getLong(getValue(QuotesProperty.SharesOutstanding)));
/*  65: 65 */     stats.setSharesOwned(Utils.getLong(getValue(QuotesProperty.SharesOwned)));
/*  66:    */     
/*  67: 67 */     stats.setEps(Utils.getBigDecimal(getValue(QuotesProperty.DilutedEPS)));
/*  68: 68 */     stats.setPe(Utils.getBigDecimal(getValue(QuotesProperty.PERatio)));
/*  69: 69 */     stats.setPeg(Utils.getBigDecimal(getValue(QuotesProperty.PEGRatio)));
/*  70:    */     
/*  71: 71 */     stats.setEpsEstimateCurrentYear(Utils.getBigDecimal(getValue(QuotesProperty.EPSEstimateCurrentYear)));
/*  72: 72 */     stats.setEpsEstimateNextQuarter(Utils.getBigDecimal(getValue(QuotesProperty.EPSEstimateNextQuarter)));
/*  73: 73 */     stats.setEpsEstimateNextYear(Utils.getBigDecimal(getValue(QuotesProperty.EPSEstimateNextYear)));
/*  74:    */     
/*  75: 75 */     stats.setPriceBook(Utils.getBigDecimal(getValue(QuotesProperty.PriceBook)));
/*  76: 76 */     stats.setPriceSales(Utils.getBigDecimal(getValue(QuotesProperty.PriceSales)));
/*  77: 77 */     stats.setBookValuePerShare(Utils.getBigDecimal(getValue(QuotesProperty.BookValuePerShare)));
/*  78:    */     
/*  79: 79 */     stats.setOneYearTargetPrice(Utils.getBigDecimal(getValue(QuotesProperty.OneyrTargetPrice)));
/*  80: 80 */     stats.setEBITDA(Utils.getBigDecimal(getValue(QuotesProperty.EBITDA)));
/*  81: 81 */     stats.setRevenue(Utils.getBigDecimal(getValue(QuotesProperty.Revenue)));
/*  82:    */     
/*  83: 83 */     return stats;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public StockDividend getDividend()
/*  87:    */   {
/*  88: 87 */     String symbol = getValue(QuotesProperty.Symbol);
/*  89: 88 */     StockDividend dividend = new StockDividend(symbol);
/*  90:    */     
/*  91: 90 */     dividend.setPayDate(Utils.parseDividendDate(getValue(QuotesProperty.DividendPayDate)));
/*  92: 91 */     dividend.setExDate(Utils.parseDividendDate(getValue(QuotesProperty.ExDividendDate)));
/*  93: 92 */     dividend.setAnnualYield(Utils.getBigDecimal(getValue(QuotesProperty.TrailingAnnualDividendYield)));
/*  94: 93 */     dividend.setAnnualYieldPercent(Utils.getBigDecimal(getValue(QuotesProperty.TrailingAnnualDividendYieldInPercent)));
/*  95:    */     
/*  96: 95 */     return dividend;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public Stock getStock()
/* 100:    */   {
/* 101: 99 */     String symbol = getValue(QuotesProperty.Symbol);
/* 102:100 */     Stock stock = new Stock(symbol);
/* 103:    */     
/* 104:102 */     stock.setName(getValue(QuotesProperty.Name));
/* 105:103 */     stock.setCurrency(getValue(QuotesProperty.Currency));
/* 106:104 */     stock.setStockExchange(getValue(QuotesProperty.StockExchange));
/* 107:    */     
/* 108:106 */     stock.setQuote(getQuote());
/* 109:107 */     stock.setStats(getStats());
/* 110:108 */     stock.setDividend(getDividend());
/* 111:    */     
/* 112:110 */     return stock;
/* 113:    */   }
/* 114:    */ }


/* Location:           C:\Users\Mike\Desktop\YahooFinanceAPI-1.4.0.jar
 * Qualified Name:     yahoofinance.quotes.stock.StockQuotesData
 * JD-Core Version:    0.7.0.1
 */