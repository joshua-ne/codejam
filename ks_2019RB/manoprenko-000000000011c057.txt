#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Stone {
    int s, e, l;

    Stone() {}
};

bool cmp(const Stone& a, const Stone& b) {
    return a.l * b.s > b.l * a.s;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    for (int tt = 1; tt <= t; ++tt) {
        int n;
        cin >> n;
        vector<Stone> a(n);
        int ss = 0;
        for (int i = 0; i < n; ++i) {
            cin >> a[i].s >> a[i].e >> a[i].l;
            ss += a[i].s;
        }
        sort(a.begin(), a.end(), cmp);

        vector<vector<int>> dp(n + 1, vector<int>(ss + 1, -1));
        dp[0][0] = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < ss; ++j) {
                if (dp[i][j] != -1) {
                    dp[i + 1][j + a[i].s] = max(dp[i + 1][j + a[i].s], dp[i][j] + (int) max(0LL, a[i].e - 1LL * a[i].l * j));
                    dp[i + 1][j] = max(dp[i + 1][j], dp[i][j]);
                }
            }
        }

        int ans = *max_element(dp[n].begin(), dp[n].end());
        cout << "Case #" << tt << ": " << ans << "\n";
    }

    return 0;
}
