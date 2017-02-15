package io.reactivesw.product.application.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

/**
 * Created by umasuo on 16/11/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel
public class ProductVariantAvailabilityView {

  @ApiModelProperty(required = false)
  private Boolean isOnStock;

  @ApiModelProperty(value = "The number of days it takes to restock a product once it is out of stock.",
          required = false)
  private Integer restockableInDays;

  @ApiModelProperty(value = "The number of items of this product variant that are currently available in stock\n." +
          "isOnStock, restockableInDays and quantityOnStock are based on the Inventory Entry with no supply channel for this variant.",
          required = false)
  private Integer availableQuantity;

  @ApiModelProperty(value = "Map of ProductVariantAvailabilityView per Channel id.For each Inventory Entries with a supply channel, an entry is added into channel:\n" +
          "the key is the Channel id\n" +
          "the value is an object containing the data isOnStock, restockableInDays and availableQuantity for the Inventory Entry with the supply channel for this variant.",
          required = false)
  private Map<String, ProductVariantAvailabilityView> channels;


}
