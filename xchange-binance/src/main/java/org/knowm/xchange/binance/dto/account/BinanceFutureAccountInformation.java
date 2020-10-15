package org.knowm.xchange.binance.dto.account;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BinanceFutureAccountInformation {

  private BigDecimal feeTier;
  private boolean canTrade;
  private boolean canDeposit;
  private boolean canWithdraw;
  private long updateTime;
  private BigDecimal totalInitialMargin;
  private BigDecimal totalMaintMargin;
  private BigDecimal totalWalletBalance;
  private BigDecimal totalUnrealizedProfit;
  private BigDecimal totalMarginBalance;
  private BigDecimal totalPositionInitialMargin;
  private BigDecimal totalOpenOrderInitialMargin;
  private BigDecimal totalCrossWalletBalance;
  private BigDecimal totalCrossUnPnl;
  private BigDecimal availableBalance;
  private BigDecimal maxWithdrawAmount;
  private FutureAssetDetail[] assets;
  private FuturePosition[] positions;
  
  public Date getUpdateTime() {
    return new Date(updateTime);
  }
}
