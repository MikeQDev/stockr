/*   1:    */ package yahoofinance.quotes;
/*   2:    */ 
/*   3:    */ public enum QuotesProperty
/*   4:    */ {
/*   5: 11 */   AfterHoursChangeRealtime("c8"),  AnnualizedGain("g3"),  Ask("a"),  AskRealtime("b2"),  AskSize("a5"),  AverageDailyVolume("a2"),  Bid("b"),  BidRealtime("b3"),  BidSize("b6"),  BookValuePerShare("b4"),  Change("c1"),  Change_ChangeInPercent("c"),  ChangeFromFiftydayMovingAverage("m7"),  ChangeFromTwoHundreddayMovingAverage("m5"),  ChangeFromYearHigh("k4"),  ChangeFromYearLow("j5"),  ChangeInPercent("p2"),  ChangeInPercentRealtime("k2"),  ChangeRealtime("c6"),  Commission("c3"),  Currency("c4"),  DaysHigh("h"),  DaysLow("g"),  DaysRange("m"),  DaysRangeRealtime("m2"),  DaysValueChange("w1"),  DaysValueChangeRealtime("w4"),  DividendPayDate("r1"),  TrailingAnnualDividendYield("d"),  TrailingAnnualDividendYieldInPercent("y"),  DilutedEPS("e"),  EBITDA("j4"),  EPSEstimateCurrentYear("e7"),  EPSEstimateNextQuarter("e9"),  EPSEstimateNextYear("e8"),  ExDividendDate("q"),  FiftydayMovingAverage("m3"),  SharesFloat("f6"),  HighLimit("l2"),  HoldingsGain("g4"),  HoldingsGainPercent("g1"),  HoldingsGainPercentRealtime("g5"),  HoldingsGainRealtime("g6"),  HoldingsValue("v1"),  HoldingsValueRealtime("v7"),  LastTradeDate("d1"),  LastTradePriceOnly("l1"),  LastTradeRealtimeWithTime("k1"),  LastTradeSize("k3"),  LastTradeTime("t1"),  LastTradeWithTime("l"),  LowLimit("l3"),  MarketCapitalization("j1"),  MarketCapRealtime("j3"),  MoreInfo("i"),  Name("n"),  Notes("n4"),  OneyrTargetPrice("t8"),  Open("o"),  OrderBookRealtime("i5"),  PEGRatio("r5"),  PERatio("r"),  PERatioRealtime("r2"),  PercentChangeFromFiftydayMovingAverage("m8"),  PercentChangeFromTwoHundreddayMovingAverage("m6"),  ChangeInPercentFromYearHigh("k5"),  PercentChangeFromYearLow("j6"),  PreviousClose("p"),  PriceBook("p6"),  PriceEPSEstimateCurrentYear("r6"),  PriceEPSEstimateNextYear("r7"),  PricePaid("p1"),  PriceSales("p5"),  Revenue("s6"),  SharesOwned("s1"),  SharesOutstanding("j2"),  ShortRatio("s7"),  StockExchange("x"),  Symbol("s"),  TickerTrend("t7"),  TradeDate("d2"),  TradeLinks("t6"),  TradeLinksAdditional("f"),  TwoHundreddayMovingAverage("m4"),  Volume("v"),  YearHigh("k"),  YearLow("j"),  YearRange("w");
/*   6:    */   
/*   7:    */   private final String tag;
/*   8:    */   
/*   9:    */   private QuotesProperty(String tag)
/*  10:    */   {
/*  11:104 */     this.tag = tag;
/*  12:    */   }
/*  13:    */   
/*  14:    */   public String getTag()
/*  15:    */   {
/*  16:108 */     return this.tag;
/*  17:    */   }
/*  18:    */ }


/* Location:           C:\Users\Mike\Desktop\YahooFinanceAPI-1.4.0.jar
 * Qualified Name:     yahoofinance.quotes.QuotesProperty
 * JD-Core Version:    0.7.0.1
 */