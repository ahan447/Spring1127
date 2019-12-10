package kakao.neo.Di.domain;

public class Birth {
	private int year;
	private int Month;
	private int  day;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return Month;
	}
	public void setMonth(int month) {
		Month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	@Override
	public String toString() {
		return "Birth [year=" + year + ", Month=" + Month + ", day=" + day + "]";
	}
	
	
}
