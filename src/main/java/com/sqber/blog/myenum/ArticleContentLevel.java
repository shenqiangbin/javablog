package com.sqber.blog.myenum;

public enum ArticleContentLevel {
	 /**
	 * 正常
	 */
	Common(0),
	/**
	 * 置顶
	 */
	Top(1),
	/**
	 *  精华
	 */
	Good(2);
	
	private int value;
	public int getValue() {
		return this.value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
    //构造方法必须是private或者默认
    private ArticleContentLevel(int value) {
        this.value = value;
    }

    public ArticleContentLevel valueOf(int value) {
        switch (value) {
        case 0:
            return ArticleContentLevel.Common;
        case 1:
            return ArticleContentLevel.Top;
        case 2:
                return ArticleContentLevel.Good;
        default:
            return null;
        }
    }
}
