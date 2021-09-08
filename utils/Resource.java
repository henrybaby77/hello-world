package com.henrybaby.paperartist.utils;

import com.henrybaby.paperartist.constant.MediaConstant;

/**
 * To obtain resource path.
 */
public class Resource implements IResource {
    private final String uri;


    public Resource(String uri) {
        this.uri = uri;
    }

    /**
     * To obtain resource path.
     *
     * @return resource path.
     */
    public String getResourcePath() {
        if (uri == null || !uri.startsWith(MediaConstant.OHOS_RESOURCE_SCHEME)) {
            return "";
        }
        return uri.substring(MediaConstant.OHOS_RESOURCE_SCHEME.length());
    }
}
