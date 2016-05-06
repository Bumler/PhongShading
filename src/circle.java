
public class circle {
	int[][] frameBuffer;
	int centerX;
	int centerY;
	int radius;
	
	public circle(int[][] framebufferIn, int cXIn, int cYIn, int radiusIn){
		frameBuffer = framebufferIn;
		centerX = cXIn;
		centerY = cYIn;
		radius = radiusIn;
	}
	
	public void fillBuffer(){
		for (int i = 0; i<frameBuffer.length; i++){
			for (int j = 0; j < frameBuffer[i].length; j++){
				double x = (j - centerX);
				double y = (i - centerY);
				double z;
				System.out.println(x+" "+y+" "+radius);
				if ((Math.sqrt((x*x) + (y*y))) < (radius)){
					System.out.println(i+" "+j);
					z = Math.sqrt((radius * radius)-((x*x)+(y*y)));
					double mag = Math.sqrt(((2*x)*(2*x)) + ((2*y)*(2*y))+ ((2*z)*(2*z)));
					//double mag = Math.sqrt(((x)*(x)) + ((y)*(y))+ ((z)*(z)));
					double[] uVec = {(2*x)/mag, (2*y)/mag, (2*z)/mag};
					//double[] uVec = {x/mag, y/mag, z/mag};
					double[] light = {10,10,-1};
					
					double theta = Math.acos(((uVec[0] * light[0])+(uVec[1] * light[1])+(uVec[2] * light[2]))
							/ (Math.sqrt((light[0]*light[0])+(light[1]*light[1])+(light[2]*light[2]))));
					
					int pixColor = (int)((theta*255)/Math.PI);
					System.out.println(pixColor);
					
					frameBuffer[i][j] = pixColor;
				}
			}
		}
	}
}
