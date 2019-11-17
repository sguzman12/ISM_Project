package dao;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductSoldComposite implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "SaleNum")
    private int saleNum;
 
    @Column(name = "ProductID")
    private int productID;
 
    public ProductSoldComposite() {
    	
    }
 
    public ProductSoldComposite(int saleNum, int productID) {
        this.saleNum = saleNum;
        this.productID = productID;
    }
 
    public int getSaleNum() {
        return saleNum;
    }
 
    public int getProductID() {
        return productID;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductSoldComposite)) return false;
        ProductSoldComposite that = (ProductSoldComposite) o;
        return Objects.equals(getSaleNum(), that.getSaleNum()) &&
                Objects.equals(getProductID(), that.getProductID());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getSaleNum(), getProductID());
    }
}

