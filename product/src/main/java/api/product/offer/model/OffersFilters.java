package api.product.offer.model;

import lombok.Data;

@Data
public class OffersFilters {
    private Integer offset;
    private Integer count;
    private SortOrder sortOrder;
    private String filter;


    enum SortOrder {
        ASC, DESC
    }
}
