/**
 *
 */
package com.sncustomcore.service.impl;

import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

import com.sncustomcore.dao.CustomBrandDao;
import com.sncustomcore.service.CustomBrandService;


/**
 * @author Anand.Mund
 *
 */
public class CustomBrandServiceImpl implements CustomBrandService {
	private CustomBrandDao brandDao;

	/**
	 * @return the brandDao
	 */
	public CustomBrandDao getBrandDao()
	{
		return brandDao;
	}

	/**
	 * @param brandDao
	 *           the brandDao to set
	 */
	public void setBrandDao(final CustomBrandDao brandDao)
	{
		this.brandDao = brandDao;
	}

	@Override
	public List<ProductModel> getBrand()
	{
		final List<ProductModel> brandList = getBrandDao().getBrand();

		return brandList;
	}

}
