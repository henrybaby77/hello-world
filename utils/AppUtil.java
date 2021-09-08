package com.henrybaby.paperartist.utils;

import ohos.agp.components.Image;
import ohos.agp.utils.Color;
import ohos.agp.utils.Point;
import ohos.agp.window.service.Display;
import ohos.agp.window.service.DisplayManager;
import ohos.app.Context;
import ohos.distributedschedule.interwork.DeviceInfo;
import ohos.distributedschedule.interwork.DeviceManager;
import ohos.global.resource.NotExistException;
import ohos.global.resource.WrongTypeException;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * AppUtil
 */
public class AppUtil {
    private static final HiLogLabel LABEL = new HiLogLabel(0, 0, "AppUtil");

    /**
     * Get width and height of screen
     *
     * @param context context
     * @return point
     */
    public static Point getScreenInfo(Context context) {
        DisplayManager displayManager = DisplayManager.getInstance();
        Optional<Display> optDisplay = displayManager.getDefaultDisplay(context);
        Point point = new Point(0, 0);
        optDisplay.ifPresent(display -> display.getSize(point));
        return point;
    }

    /**
     * Get string resource
     *
     * @param context context
     * @param id      id
     * @return String
     */
    public static String getStringResource(Context context, int id) {
        try {
            return context.getResourceManager().getElement(id).getString();
        } catch (IOException e) {
            HiLog.info(LABEL, "IOException");
        } catch (NotExistException e) {
            HiLog.info(LABEL, "NotExistException");
        } catch (WrongTypeException e) {
            HiLog.info(LABEL, "WrongTypeException");
        }
        return "";
    }

    /**
     * Get float resource
     *
     * @param context context
     * @param id      id
     * @return Int
     */
    public static float getFloatResource(Context context, int id) {
        try {
            return context.getResourceManager().getElement(id).getFloat();
        } catch (IOException e) {
            HiLog.info(LABEL, "IOException");
        } catch (NotExistException e) {
            HiLog.info(LABEL, "The resource is not exist");
        } catch (WrongTypeException e) {
            HiLog.info(LABEL, "WrongTypeException");
        }
        return -1;
    }

    /**
     * Obtains dimension value
     *
     * @param context context
     * @param id      resource id
     * @return the value of dimension
     */
    public static int getDimension(Context context, int id) {
        float value = getFloatResource(context, id);
        return Math.round(value + 0.5f);
    }

    /**
     * Obtains the color by resource id
     *
     * @param context context
     * @param id      resource id
     * @return color
     */
    public static Color getColor(Context context, int id) {
        return new Color(context.getColor(id));
    }

    /**
     * Obtains the string array by resource id
     *
     * @param context context
     * @param id      resource id
     * @return string array
     */
    public static String[] getStringArray(Context context, int id) {
        try {
            return context.getResourceManager().getElement(id).getStringArray();
        } catch (IOException e) {
            HiLog.info(LABEL, "IOException");
        } catch (NotExistException e) {
            HiLog.info(LABEL, "NotExistException");
        } catch (WrongTypeException e) {
            HiLog.info(LABEL, "WrongTypeException");
        }
        return new String[]{};
    }
}
