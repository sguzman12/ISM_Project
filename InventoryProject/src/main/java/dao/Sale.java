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

	/**
	 * Default Constructor
	 */
	public Sale()
	{
	}

	/**
	 * One parameter Constructor
	 * 
	 * @param id
	 *            Sale Number
	 */
	public Sale(int id)
	{
		this.id = id;
	}

	/**
	 * Two parameter Constructor
	 * 
	 * @param id
	 *            Sale Number
	 * @param cust
	 *            Customer ID
	 */
	public Sale(int id, int cust)
	{
		this.id = id;
		cstID = cust;
	}

	/**
	 * Three parameter Constructor
	 * 
	 * @param id
	 *            Sale Number
	 * @param cust
	 *            Customer ID
	 * @param saleA
	 *            Sale Amount
	 */
	public Sale(int id, int cust, BigDecimal saleA)
	{
		this.id = id;
		cstID = cust;
		saleAmount = saleA;
	}

	/**
	 * Four parameter Constructor
	 * 
	 * @param id
	 *            Sale Number
	 * @param cust
	 *            Customer ID
	 * @param day
	 *            Date of Sale
	 * @param saleA
	 *            Sale Amount
	 */
	public Sale(int id, int cust, Date day, BigDecimal saleA)
	{
		this.id = id;
		cstID = cust;
		saleDate = day;
		saleAmount = saleA;
	}

	/**
	 * Used to Return Sales. Order ID can be null.
	 * 
	 * @param id
	 *            Sale Number
	 * @param cust
	 *            Customer ID
	 * @param orderID
	 *            Order Number. Can be null
	 * @param day
	 *            Date of Sale
	 * @param saleA
	 *            Sale Amount
	 */
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
