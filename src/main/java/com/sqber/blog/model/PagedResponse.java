package com.sqber.blog.model;

import java.util.ArrayList;
import java.util.List;

public class PagedResponse<T> {
	private List<T> list;
	private int currentPage;
	private int totalPage;
	private long totalCount;
	private int pageSize;
	private List<Integer> pagedList;
	
	public List<T> getList() {
		return this.list;
	}
	
	public void setList(List<T> list) {
		this.list = list;
	}
	
	public int getCurrentPage() {
		return this.currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getTotalPage() {
		return this.totalPage;
	}
	
	public long getTotalCount() {
		return this.totalCount;
	}
	
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getPageSize() {
		return this.pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public void calTotalPage() {
		this.totalPage = (int)((totalCount + pageSize - 1) / pageSize);
	}
	
	public List<Integer> getPagedList() {
		this.pagedList = getPageList(this.currentPage,this.totalPage,8);
		return this.pagedList;
	}
	
	private List<Integer> getPageList(int currentIndex, int total, int disPage)
    {
        List<Integer> pageList = new ArrayList<Integer>();
        if (disPage > total)
        {
            for (int i = 1; i <= total; i++)
            {
                pageList.add(i);
            }
            return pageList;
        }

        for (int i = 1; i <= disPage; i++)
        {
            if (i < 3)
            {
                pageList.add(i);
            }
            else if (i == 3)
            {
                if (currentIndex > 5)
                {
                    pageList.add(0);
                }
                else
                {
                    pageList.add(i);
                }
            }
            else if (i < (disPage - 1))
            {
                if (currentIndex >= 5)
                {
                    if ((currentIndex + (i - 4)) >= total)
                    {
                        continue;
                    }
                    pageList.add((currentIndex + (i - 5)));
                }
                else
                {
                    pageList.add(i);
                }
            }
            else if (i == (disPage - 1))
            {
                if (total - currentIndex > 2)
                {
                    pageList.add(0);
                }
                else
                {
                    pageList.add(total - 1);
                }
            }
            else
            {
                pageList.add(total);
            }
        }

        return pageList;
    }
}
