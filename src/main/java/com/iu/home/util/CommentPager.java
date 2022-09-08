package com.iu.home.util;

public class CommentPager {
	
	private Long startRow;
	private Long lastRow;
	private Long bookNum;
	private Long page;
	private Long startNum;
	private Long lastNum;
	private Long perPage;
	private Long perBlock;
	private Long totalPage;
	
	private boolean pre;
	private boolean next;
	
	public void getRowNum() {
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();
	}
	
	public void makePage(Long totalCount)throws Exception{
		//2. totalCount로 totalPage구하기 ex)100
		this.totalPage=totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0) {
			this.totalPage++;
		}
//		
//		//2_1 totalPage보다 page가 더 클 경우
//		if(this.getPage()>totalPage) {
//			this.setPage(totalPage);
//		}
//		
//		//3. totalPage로 totalBlock 구하기
//		Long totalBlock = totalPage/this.getPerBlock();
//		if(totalPage%this.getPerBlock() != 0) {
//			totalBlock++;
//		}
//		
//		//4. page로 curBlock 찾기
//		Long curBlock = this.getPage()/this.getPerBlock();
//		if(this.getPage()%this.getPerBlock() != 0) {
//			curBlock++;
//		}
//		
//		//5. curBlock으로 startNum , lastNum 구하기
//		this.startNum = (curBlock-1)*this.getPerBlock()+1;
//		this.lastNum = curBlock*this.getPerBlock();
//		
//		//6. curBlock이 마지막block(totalBlock과 같을 때)
//		if(curBlock==totalBlock) {
//			this.lastNum=totalPage;
//		}
//		
//		//7. 이전, 다음 블럭의 유무
//		if(curBlock>1) {
//			pre=true;
//		}
//		
//		if(curBlock<totalBlock) {
//			next=true;
//		}
		
	}
	
	

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getBookNum() {
		return bookNum;
	}

	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}

	public Long getPage() {
		if(this.page==null || this.page<1) {
			this.page=1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage=5L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPerBlock() {
		if(this.perBlock==null) {
			this.perBlock=5L;
		}
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	
	

	
	
	
	
	

}
