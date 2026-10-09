public static int DotProduct(int[][] v1, int[][] v2) {
    int ptrV1 = 0, ptrV2 = 0;
    int rem1 = v1[0][1], rem2 = v2[0][1];
    int res = 0;

    while (ptrV1 < v1.length && ptrV2 < v2.length) {
        int take = Math.min(rem1, rem2);
        res += v1[ptrV1][0] * v2[ptrV2][0] * take;

        rem1 -= take;
        rem2 -= take;

        if (rem1 == 0) {
            ptrV1++;
            if (ptrV1 < v1.length) rem1 = v1[ptrV1][1];
        }
        if (rem2 == 0) {
            ptrV2++;
            if (ptrV2 < v2.length) rem2 = v2[ptrV2][1];
        }
    }
    return res;
}