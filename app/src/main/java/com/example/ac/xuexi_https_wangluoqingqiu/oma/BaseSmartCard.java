package com.example.ac.xuexi_https_wangluoqingqiu.oma;


public abstract class BaseSmartCard {
    private EnumReaderType mReaderType;
    final int STATUS_CODE_SUCCESS = 0;
    final int STATUS_CODE_FAIL = -1;

    public abstract CardResult execute(String command);

    /**
     * 打开通道
     * @param command
     * @return
     */
    public abstract CardResult openChannel(String command);

    public abstract void closeChannel();

    public abstract void closeService();


    CardResult operFail(String errorMsg) {
        closeChannel();
        return new CardResult(STATUS_CODE_FAIL, errorMsg);
    }

    public EnumReaderType getmReaderType() {
        if (mReaderType == null) {
            return EnumReaderType.READER_TYPE_SIM;
        }
        return mReaderType;
    }

    public void setmReaderType(EnumReaderType mReaderType) {
        this.mReaderType = mReaderType;
    }

}
