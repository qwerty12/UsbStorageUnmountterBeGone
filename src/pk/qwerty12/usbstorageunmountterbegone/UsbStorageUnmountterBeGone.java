package pk.qwerty12.usbstorageunmountterbegone;

import android.os.PowerManager.WakeLock;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

public class UsbStorageUnmountterBeGone implements IXposedHookZygoteInit {
	
	@Override
	public void initZygote(StartupParam startupParam) throws Throwable {
		try {
			XposedHelpers.findAndHookMethod("com.android.internal.os.storage.UsbStorageUnmountter", null, "onCreate",  
				new XC_MethodHook()
				{
					@Override
					protected void afterHookedMethod(MethodHookParam param) throws Throwable
					{
						WakeLock mWakeLock = (WakeLock) XposedHelpers.getObjectField(param.thisObject, "mWakeLock");
						mWakeLock.release();
					}

			    });
		} catch (Throwable t) { XposedBridge.log(t); }
	}

}
