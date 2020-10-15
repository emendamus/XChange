package org.knowm.xchange.binance.dto.account;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FutureAssetDetail {

  private String asset;
  private BigDecimal walletBalance;
  private BigDecimal unrealizedProfit;
  private BigDecimal marginBalance;
  private BigDecimal maintMargin;
  private BigDecimal initialMargin;
  private BigDecimal positionInitialMargin;
  private BigDecimal openOrderInitialMargin;
  private BigDecimal crossWalletBalance;
  private BigDecimal crossUnPnl;
  private BigDecimal availableBalance;
  private BigDecimal maxWithdrawAmount;
  
}
