/**
 *
 */
package com.sncustomfacades.brand.impl;

import de.hybris.platform.category.CategoryService;
import de.hybris.platform.category.model.CategoryModel;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.sncustomcore.service.CustomBrandService;
import com.sncustomfacades.brand.CustomBrandFacade;
import com.sncustomwebservices.facades.data.BrandData;

/**
 * @author Anand.Mund
 *
 */
public class CustomBrandFacadeImpl implements CustomBrandFacade {

	private CustomBrandService brandService;
	private CategoryService categoryService;

	/**
	 * @return the brandService
	 */
	public CustomBrandService getBrandService()	{
		return brandService;
	}

	/**
	 * @param brandService the brandService to set
	 */
	public void setBrandService(final CustomBrandService brandService)	{
		this.brandService = brandService;
	}

	@Override
	public BrandData getBrand()	{

		final BrandData brandList = new BrandData();
		final Set<String> brandSet = new HashSet<String>();

		final Collection<CategoryModel> category = getCategoryService().getCategoriesForCode("brands");

		for (final CategoryModel categoryModel : category)		{
			final Collection<CategoryModel> subCategory = categoryModel.getAllSubcategories();
			for (final CategoryModel categoryModel2 : subCategory){
				brandSet.add(categoryModel2.getName());
			}
		}
		brandList.setBrand(brandSet);

		/*final List<ProductModel> productList = getBrandService().getBrand();
		final List<ProductData> productDataList = new LinkedList<ProductData>();


		for (final ProductModel productModel : productList){
			final String brandName = productModel.getManufacturerName();
			brandSet.add(brandName);
			}
		brandList.setBrand(brandSet);*/
		return brandList;
	}

	/**
	 * @return the categoryService
	 */
	public CategoryService getCategoryService()	{
		return categoryService;
	}

	/**
	 * @param categoryService the categoryService to set
	 */
	public void setCategoryService(final CategoryService categoryService)	{
		this.categoryService = categoryService;
	}

}
