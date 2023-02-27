private boolean isIPv4(String ipv4){

        final String IPV4_REGEX ="^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        if (ipv4 != null) {
            return java.util.regex.Pattern.compile(IPV4_REGEX).matcher(ipv4).matches();
        }else {
            return false;
        }
    }