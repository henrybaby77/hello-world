package com.henrybaby.paperartist.utils;

import com.henrybaby.paperartist.controller.MeasureHelper;
import ohos.agp.utils.Point;
import ohos.agp.window.service.Display;
import ohos.agp.window.service.DisplayManager;
import ohos.app.Context;
import ohos.hiviewdfx.HiLog;

import java.util.Optional;

/**
 * Screen Util
 */
public class ScreenUtils {
    private ScreenUtils() {
    }

    /**
     * get Screen Width Method
     *
     * @param context context
     * @return screen width
     */
    public static int getScreenWidth(Context context) {
        DisplayManager displayManager = DisplayManager.getInstance();
        Optional<Display> optDisplay = displayManager.getDefaultDisplay(context);
        Point point = new Point(0, 0);
        if (optDisplay.isPresent()) {
            Display display = optDisplay.get();
            display.getSize(point);
        }
        return (int) point.position[0];
    }

    /**
     * get Screen size from context.
     *
     * @param context component context.
     * @return Point instance
     */
    public static Point getScreenSize(Context context) {
        Point point = new Point(0, 0);
        DisplayManager displayManager = DisplayManager.getInstance();
        Optional<Display> optDisplay = displayManager.getDefaultDisplay(context);
        optDisplay.ifPresent(display -> display.getSize(point));
        HiLog.debug(MeasureHelper.LABEL, "Screen size = " + point.toString());
        return point;
    }

    /**
     * Screen orientation is portrait?
     *
     * @param context Component context.
     * @return whether component is in portrait mode.
     */
    public static boolean isPortrait(Context context) {
        Point screenSize = getScreenSize(context);
        return screenSize.getPointYToInt() >= screenSize.getPointXToInt();
    }
}
