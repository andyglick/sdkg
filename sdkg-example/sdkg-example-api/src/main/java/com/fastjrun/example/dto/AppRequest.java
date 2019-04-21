/*
 * Copyright (C) 2019 fastjrun, Inc. All Rights Reserved.
 */
package com.fastjrun.example.dto;

import java.io.Serializable;

public class AppRequest<T> extends BasePacket<AppRequestHead, T> implements Serializable {

    private static final long serialVersionUID = 3239818956546089368L;
}
