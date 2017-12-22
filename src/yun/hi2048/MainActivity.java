package yun.hi2048;

import java.util.Random;
import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;


public class MainActivity extends Activity {

	private GridView gv;
	private ImageView iv;
	private int x1,x2,y1,y2;
	private ImageView v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16;
	private Array myarray;
	Random random=new Random();
	private TextView tv1,tv2;
	private int win=1,count=0,score=163844;
	private AlertDialog.Builder showanswer;
	private MenuItem exit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		showanswer=new AlertDialog.Builder(this);
		tv1=(TextView)findViewById(R.id.textView1);
		tv2=(TextView)findViewById(R.id.textView2);
		tv1.setTextColor(Color.RED);
		tv2.setTextColor(Color.RED);
		tv2.setText(score+"");
		v1=(ImageView)findViewById(R.id.imageView1);
		v2=(ImageView)findViewById(R.id.imageView2);
		v3=(ImageView)findViewById(R.id.imageView3);
		v4=(ImageView)findViewById(R.id.imageView4);
		
		v5=(ImageView)findViewById(R.id.imageView5);
		v6=(ImageView)findViewById(R.id.imageView6);
		v7=(ImageView)findViewById(R.id.imageView7);
		v8=(ImageView)findViewById(R.id.imageView8);
		
		v9=(ImageView)findViewById(R.id.imageView9);
		v10=(ImageView)findViewById(R.id.imageView10);
		v11=(ImageView)findViewById(R.id.imageView11);
		v12=(ImageView)findViewById(R.id.imageView12);
		
		v13=(ImageView)findViewById(R.id.imageView13);
		v14=(ImageView)findViewById(R.id.imageView14);
		v15=(ImageView)findViewById(R.id.imageView15);
		v16=(ImageView)findViewById(R.id.imageView16);
		myarray=new Array();
		myarray.show();
		myarray.number[0][3].num=4096;
		myarray.number[0][2].num=4096;
		myarray.number[0][1].num=2048;
		myarray.number[0][0].num=1024;
		myarray.show();
		
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		exit=menu.add("Exit");
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		finish();
		return super.onOptionsItemSelected(item);
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if(event.getAction() == MotionEvent.ACTION_DOWN) {  
            //当手指按下的时候  
            x1 = (int) event.getX();  
            y1 = (int) event.getY();  
        }  
        if(event.getAction() == MotionEvent.ACTION_UP) {  
            //当手指离开的时候 
        	int sign=0,num,x,y;
            x2 = (int) event.getX();  
            y2 = (int) event.getY();  
            if(x1 - x2 > 50) {  
            	sign=0;
            	for(int k=0;k<4;k++)
            	{
            		for(int i=0;i<4;i++)
            		{
            			for(int j=i+1;j<4;j++)
            			{
            				
            				if(myarray.number[k][j].num!=0)
            				{
            					if(myarray.number[k][i].num==0)
            					{
            						myarray.number[k][i].num=myarray.number[k][j].num;
            						myarray.number[k][j].num=0;	
            						sign=1;
            						i--;
            					}
            					else if(myarray.number[k][i].num==myarray.number[k][j].num)
            					{
            						myarray.number[k][i].num+=myarray.number[k][j].num;
            						score+=myarray.number[k][i].num;
            						myarray.number[k][j].num=0;
            						sign=1;
            					}
            					break;
            				}
            			}
            			
            		}
            	}
            	if(sign==1)
            	{
            		num=random.nextInt(2);
            		if(num==0)
            			num=4;
            		else
            			num=2;
            		for(int i=0;i<16;i++)
            		{
            			x=random.nextInt(4);
            			y=random.nextInt(4);
            			if(myarray.number[x][y].num==0)
            			{
            				myarray.number[x][y].num=num;
            				break;
            			}
            		}
            		myarray.show();
            	}
            	else
            	{
            		myarray.show();
            		for(int i=0;i<4;i++)
            		{	
            			for(int j=0;j<4;j++)
            				if(myarray.number[i][j].num!=0)							
            					count++;			
            		}
            		if(count==16)
            			win=0;
            	}
            	tv2.setText(score+"");
                //Toast.makeText(MainActivity.this, "向左滑", Toast.LENGTH_SHORT).show();  
            }  else  if(y1 - y2 > 50) {  
                //Toast.makeText(MainActivity.this, "向上滑", Toast.LENGTH_SHORT).show();
                for(int k=0;k<4;k++)
            	{
            		for(int i=0;i<4;i++)
            		{
            			for(int j=i+1;j<4;j++)
            			{
            				
            				if(myarray.number[j][k].num!=0)
            				{
            					if(myarray.number[i][k].num==0)
            					{
            						myarray.number[i][k].num=myarray.number[j][k].num;
            						sign=1;
            						myarray.number[j][k].num=0;
            						i--;
            					}
            					else if(myarray.number[i][k].num==myarray.number[j][k].num)
            					{
            						myarray.number[i][k].num+=myarray.number[j][k].num;
            						score+=myarray.number[i][k].num;
            						myarray.number[j][k].num=0;
            						sign=1;
            					}
            					break;
            				}
            			}
            			
            		}
            	}
                if(sign==1)
            	{
            		num=random.nextInt(2);
            		if(num==0)
            			num=4;
            		else
            			num=2;
            		for(int i=0;i<16;i++)
            		{
            			x=random.nextInt(4);
            			y=random.nextInt(4);
            			if(myarray.number[x][y].num==0)
            			{
            				myarray.number[x][y].num=num;
            				break;
            			}
            		}
            		myarray.show();
            	}
            	else
            	{
            		myarray.show();
            		for(int i=0;i<4;i++)
            		{	
            			for(int j=0;j<4;j++)
            				if(myarray.number[i][j].num!=0)							
            					count++;			
            		}
            		if(count==16)
            			win=0;
            	}
                tv2.setText(score+"");
            } else if(x2 - x1 > 50) { 
            	sign=0;
            	for(int k=0;k<4;k++)
            	{
            		for(int i=3;i>=0;i--)
            		{
            			for(int j=i-1;j>=0;j--)
            			{
            				
            				if(myarray.number[k][j].num!=0)
            				{
            					if(myarray.number[k][i].num==0)
            					{
            						myarray.number[k][i].num=myarray.number[k][j].num;
            						myarray.number[k][j].num=0;	
            						i++;
            						sign=1;
            					}
            					else if(myarray.number[k][i].num==myarray.number[k][j].num)
            					{
            						myarray.number[k][i].num+=myarray.number[k][j].num;
            						score+=myarray.number[k][i].num;
            						myarray.number[k][j].num=0;
            						sign=1;
            					}
            					break;
            				}
            			}
            			
            		}
            	}
            	if(sign==1)
            	{
            		num=random.nextInt(2);
            		if(num==0)
            			num=4;
            		else
            			num=2;
            		for(int i=0;i<16;i++)
            		{
            			x=random.nextInt(4);
            			y=random.nextInt(4);
            			if(myarray.number[x][y].num==0)
            			{
            				myarray.number[x][y].num=num;
            				break;
            			}
            		}
            		myarray.show();
            	}
            	else
            	{
            		myarray.show();
            		for(int i=0;i<4;i++)
            		{	
            			for(int j=0;j<4;j++)
            				if(myarray.number[i][j].num!=0)							
            					count++;			
            		}
            		if(count==16)
            			win=0;
            	}
                //Toast.makeText(MainActivity.this, "向右滑", Toast.LENGTH_SHORT).show();  
            	tv2.setText(score+"");
            }else if(y2 - y1 > 50) { 
            	sign=0;
            	for(int k=0;k<4;k++)
            	{
            		for(int i=3;i>=0;i--)
            		{
            			for(int j=i-1;j>=0;j--)
            			{
            				
            				if(myarray.number[j][k].num!=0)
            				{
            					if(myarray.number[i][k].num==0)
            					{
            						myarray.number[i][k].num=myarray.number[j][k].num;
            						myarray.number[j][k].num=0;
            						sign=1;
            						i++;
            					}
            					else if(myarray.number[i][k].num==myarray.number[j][k].num)
            					{
            						myarray.number[i][k].num+=myarray.number[j][k].num;
            						score+=myarray.number[i][k].num;
            						myarray.number[j][k].num=0;
            						sign=1;
            					}
            					break;
            				}
            			}
            			
            		}
            	}
            	if(sign==1)
            	{
            		num=random.nextInt(2);
            		if(num==0)
            			num=4;
            		else
            			num=2;
            		for(int i=0;i<16;i++)
            		{
            			x=random.nextInt(4);
            			y=random.nextInt(4);
            			if(myarray.number[x][y].num==0)
            			{
            				myarray.number[x][y].num=num;
            				break;
            			}
            		}
            		myarray.show();
            	}
            	else
            	{
            		myarray.show();
            		for(int i=0;i<4;i++)
            		{	
            			for(int j=0;j<4;j++)
            				if(myarray.number[i][j].num!=0)							
            					count++;			
            		}
            		if(count==16)
            			win=0;
            	}
            	tv2.setText(score+"");
                //Toast.makeText(MainActivity.this, "向下滑", Toast.LENGTH_SHORT).show();  
            }
        }  
		return super.onTouchEvent(event);
	}
	public class Number{
		int num;
		boolean first;		
		public Number(int num){
			this.num=num;
			this.first=true;
		}
		public Number(Number n){
			this.num=n.num;
			this.first=true;
		}
		public void Destroy(){
			num=0;
		}
		
	}
	public class Array{
		Number[][] number=new Number[4][4];
		public Array(){
			number[0][0]=new Number(0);
			number[0][1]=new Number(0);
			number[0][2]=new Number(0);
			number[0][3]=new Number(0);
			number[1][0]=new Number(0);
			number[1][1]=new Number(0);
			number[1][2]=new Number(0);
			number[1][3]=new Number(0);
			number[2][0]=new Number(0);
			number[2][1]=new Number(0);
			number[2][2]=new Number(0);
			number[2][3]=new Number(0);
			number[3][0]=new Number(0);
			number[3][1]=new Number(0);
			number[3][2]=new Number(0);
			number[3][3]=new Number(0);
		}
		public void show(){
			if(win==0){
				showanswer.setTitle("游戏结束");
				showanswer.setPositiveButton("OK", null).show();
				for(int i=0;i<4;i++){
					for(int j=0;j<4;j++){
						number[i][j].num=0;
					}
				}
				win=1;
				this.show();
			}else
			{
			ImageView v;
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
				v=getView(i*4+j);
				switch(number[i][j].num){
				case 0:v.setImageResource(R.drawable.h0);break;
				case 2:v.setImageResource(R.drawable.h2);break;
				case 4:v.setImageResource(R.drawable.h4);break;
				case 8:v.setImageResource(R.drawable.h8);break;
				case 16:v.setImageResource(R.drawable.h16);break;
				case 32:v.setImageResource(R.drawable.h32);break;
				case 64:v.setImageResource(R.drawable.h64);break;
				case 128:v.setImageResource(R.drawable.h128);break;
				case 256:v.setImageResource(R.drawable.h256);break;
				case 512:v.setImageResource(R.drawable.h512);break;
				case 1024:v.setImageResource(R.drawable.h1024);break;
				case 2048:v.setImageResource(R.drawable.h2048);break;
				case 4096:v.setImageResource(R.drawable.h4096);break;
				case 8192:v.setImageResource(R.drawable.h8192);break;
				default:v.setImageResource(R.drawable.h16384);break;
				}
				}
			}}
		}
		public void up(){
			
		}
	}
	public ImageView getView(int i){
		switch(i){
		case 0:return v1;
		case 1: return v2;
		case 2: return v3;
		case 3: return v4;
		case 4: return v5;
		case 5: return v6;
		case 6: return v7;
		case 7: return v8;
		case 8: return v9;
		case 9: return v10;
		case 10: return v11;
		case 11: return v12;
		case 12: return v13;
		case 13: return v14;
		case 14: return v15;
		default: return v16;
		}
	}

}
