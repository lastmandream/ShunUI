import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.jfree.chart.JFreeChart;
import org.jfree.experimental.chart.swt.ChartComposite;

import com.NewUI.JFreeCharts.*;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

public class MyWindows {

	protected Shell shell;
	private FormData fd_frame_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MyWindows window = new MyWindows();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		
		//int shell_x = 0;
		//int shell_y = 0;
		
		//shell_x = shell.getSize().x;
		//shell_y = shell.getSize().y;
		
		Display display = Display.getDefault();
		createContents();
		
		JFreeChartBeta dataset = new JFreeChartBeta();
		
		JFreeChart barchart1 = dataset.createBarChart(dataset.createBarDataset());
		JFreeChart barchart2 = dataset.createBarChart(dataset.createBarDataset());
		JFreeChart barchart3 = dataset.createBarChart(dataset.createBarDataset());
		
		JFreeChart linechart1 = dataset.createLineChart(dataset.createLineDataset());
		JFreeChart linechart2 = dataset.createLineChart(dataset.createLineDataset());
		JFreeChart linechart3 = dataset.createLineChart(dataset.createLineDataset());
		
		shell.setLayout(new FormLayout());

		final ChartComposite frame1 = new ChartComposite(shell, SWT.EMBEDDED, barchart1,true);		
		FormData fd_frame = new FormData();
		fd_frame.top = new FormAttachment(0, 228);
		fd_frame.left = new FormAttachment(0, 19);
		fd_frame.bottom = new FormAttachment(100, -228);
		fd_frame.right = new FormAttachment(100, -931);
		fd_frame.height = 300;
		frame1.setLayoutData(fd_frame);
		
		final ChartComposite frame2 = new ChartComposite(shell, SWT.EMBEDDED, barchart2,true);
		FormData fd_frame2 = new FormData();
		fd_frame2.top = new FormAttachment(0, 228);
		fd_frame2.right = new FormAttachment(100, -20);
		fd_frame2.bottom = new FormAttachment(100, -228);
		fd_frame2.height = 300;
		frame2.setLayoutData(fd_frame2);


		
		final ChartComposite frame3 = new ChartComposite(shell, SWT.EMBEDDED, barchart3,true);
		fd_frame2.left = new FormAttachment(frame3, 19);
		FormData fd_frame3 = new FormData();
		fd_frame3.left = new FormAttachment(frame1, 19);
		fd_frame3.right = new FormAttachment(100, -475);
		fd_frame3.top = new FormAttachment(0, 228);
		fd_frame3.bottom = new FormAttachment(100, -228);
		frame3.setLayoutData(fd_frame3);
		
		final ChartComposite frame4 = new ChartComposite(shell, SWT.EMBEDDED, linechart1,true);
		FormData fd_frame4 = new FormData();
		fd_frame4.top = new FormAttachment(frame1, 6);
		fd_frame4.left = new FormAttachment(frame1, 0, SWT.LEFT);
		fd_frame4.right = new FormAttachment(0, 419);
		frame4.setLayoutData(fd_frame4);
		
		final ChartComposite frame5 = new ChartComposite(shell, SWT.EMBEDDED, linechart2,true);
		fd_frame4.bottom = new FormAttachment(frame5, 0, SWT.BOTTOM);
		FormData fd_frame5 = new FormData();
		fd_frame5.bottom = new FormAttachment(frame1, 228, SWT.BOTTOM);
		fd_frame5.right = new FormAttachment(frame3, 0, SWT.RIGHT);
		fd_frame5.top = new FormAttachment(frame3, 6);
		fd_frame5.left = new FormAttachment(frame3, 0, SWT.LEFT);
		frame5.setLayoutData(fd_frame5);
		
		final ChartComposite frame6 = new ChartComposite(shell, SWT.EMBEDDED, linechart3,true);
		FormData fd_frame6 = new FormData();
		fd_frame6.bottom = new FormAttachment(frame4, 0, SWT.BOTTOM);
		fd_frame6.right = new FormAttachment(frame2, 0, SWT.RIGHT);
		fd_frame6.top = new FormAttachment(frame2, 6);
		fd_frame6.left = new FormAttachment(frame2, 0, SWT.LEFT);
		frame6.setLayoutData(fd_frame6);
		
		Composite composite = new Composite(shell, SWT.NONE);
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(frame2, -6);
		fd_composite.right = new FormAttachment(100, -44);
		fd_composite.top = new FormAttachment(0);
		fd_composite.left = new FormAttachment(100, -424);
		composite.setLayoutData(fd_composite);
		final Image image = new Image(display, "resource\\cortex.jpg");
		//composite.setBackgroundImage(SWTResourceManager.getImage("resource\\cortex.jpg"));
		composite.setBackgroundImage(image);


		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(1366, 768);
		shell.setMaximized(true);
		shell.setText("SWT Application");

	}
}
