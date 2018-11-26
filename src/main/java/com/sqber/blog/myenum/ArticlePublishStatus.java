package com.sqber.blog.myenum;

public enum ArticlePublishStatus {
	 /**
	 *  未发布
	 */
	Not(0),
	/**
	 * 已发布
	 */
	Published(1),
	/**
	 *  全部
	 */
	All(2);
	
	private int value;
	public int getValue() {
		return this.value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
    //构造方法必须是private或者默认
    private ArticlePublishStatus(int value) {
        this.value = value;
    }

    public ArticlePublishStatus valueOf(int value) {
        switch (value) {
        case 0:
            return ArticlePublishStatus.Not;
        case 1:
            return ArticlePublishStatus.Published;
        case 2:
                return ArticlePublishStatus.All;
        default:
            return null;
        }
    }
}
