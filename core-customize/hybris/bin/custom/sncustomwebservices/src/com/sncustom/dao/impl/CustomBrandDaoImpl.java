/**
 *
 */
package com.sncustom.dao.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.List;

import com.sncustomcore.dao.CustomBrandDao;


/**
 * @author Anand.Mund
 *
 */
public class CustomBrandDaoImpl implements CustomBrandDao {

	private static final String GET_BRAND_QUERY = "select {pk},{code},{manufacturername} from {product} where {catalogversion}='8796093383257' "
			+ "and {approvalstatus}= '8796100853851' and {manufacturername} is not null";

	private FlexibleSearchService flexibleSearchService;

	/**
	 * @return the flexibleSearchService
	 */
	public FlexibleSearchService getFlexibleSearchService()	{
		return flexibleSearchService;
	}

	/**
	 * @param flexibleSearchService the flexibleSearchService to set
	 */
	public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)	{
		this.flexibleSearchService = flexibleSearchService;
	}

	@Override
	public List<ProductModel> getBrand()	{
		final SearchResult<ProductModel> searchResult = getFlexibleSearchService().search(GET_BRAND_QUERY);
		final List<ProductModel> brandList = searchResult.getResult();

		return brandList;
	}

}
