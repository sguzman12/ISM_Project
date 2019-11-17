package dao;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "productsold")
public class ProductSold
{
	@EmbeddedId
    private ProductSoldComposite id;
 
    private int quantity;
 
    public ProductSoldComposite getId() {
        return id;
    }

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public void setId(ProductSoldComposite id)
	{
		this.id = id;
	}
}
