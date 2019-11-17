package dao;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sale DAO object class using hibernate annotations.
 * 
 * @author Sigfredo Guzman
 *
 */
@Entity
@Table(name = "sales")
public class Sale
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SaleNum")
	private int id;

	@Column(name = "CustID")
	private int cstID;

	@Column(name = "OrderNum")
	private Integer ordNum;

	@Column(name = "SaleDate")
	private Date saleDate;

	@Column(name = "SaleAmount")
	private BigDecimal saleAmount;

	public Sale()
	{
	}

	public Sale(int id)
	{
		this.id = id;
	}

	public Sale(int id, int cust)
	{
		this.id = id;
		cstID = cust;
	}

	public Sale(int id, int cust, BigDecimal saleA)
	{
		this.id = id;
		cstID = cust;
		saleAmount = saleA;
	}

	public Sale(int id, int cust, Date day, BigDecimal saleA)
	{
		this.id = id;
		cstID = cust;
		saleDate = day;
		saleAmount = saleA;
	}

	public Sale(int id, int cust, Integer orderID, Date day, BigDecimal saleA)
	{
		this.id = id;
		cstID = cust;
		ordNum = orderID;
		saleDate = day;
		saleAmount = saleA;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getCstID()
	{
		return cstID;
	}

	public void setCstID(int cstID)
	{
		this.cstID = cstID;
	}

	public Integer getOrdNum()
	{
		return ordNum;
	}

	public void setOrdNum(Integer ordNum)
	{
		if(ordNum == null)
		{
			this.ordNum = 0;
			
		}
		else
		{
			this.ordNum = ordNum;
		}
	}

	public Date getSaleDate()
	{
		return saleDate;
	}

	public void setSaleDate(Date saleDate)
	{
		this.saleDate = saleDate;
	}

	public BigDecimal getSaleAmount()
	{
		return saleAmount;
	}

	public void setSaleAmount(BigDecimal saleAmount)
	{
		this.saleAmount = saleAmount;
	}
}
